package cn.crawlite4j.core.engine;

import java.lang.Thread.State;
import java.util.ArrayList;
import java.util.List;

import cn.crawlite4j.core.crawler.ICrawler;
import cn.crawlite4j.core.downloader.IDownloader;
import cn.crawlite4j.core.downloader.IDownloaderMiddleware;
import cn.crawlite4j.core.item.IItem;
import cn.crawlite4j.core.item.NewRequestItem;
import cn.crawlite4j.core.parser.IParser;
import cn.crawlite4j.core.parser.IParserMiddleware;
import cn.crawlite4j.core.pipeline.IPipeline;
import cn.crawlite4j.core.pipeline.IPipelineMiddleware;
import cn.crawlite4j.core.request.IRequest;
import cn.crawlite4j.core.request.IgnoreRequestException;
import cn.crawlite4j.core.response.IgnoreResponseException;
import cn.crawlite4j.core.scheduler.IScheduler;
import cn.crawlite4j.core.scheduler.ISchedulerMiddleware;

public final class MutilThreadEngine extends AbstractEngine {

	private volatile boolean run = false;
	private volatile Object lock = new Object();
	private int num;
	private List<Thread> threads;

	// ***********************************************************************//
	// Constructor
	// ***********************************************************************//

	public MutilThreadEngine(int threadNum) {
		super();
		num = threadNum;
		threads = new ArrayList<Thread>(num);
	}

	public MutilThreadEngine() {
		this(1);
	}

	// ***********************************************************************//
	// implemented functions
	// ***********************************************************************//

	@Override
	public void startEngine() {
		for (int i = 0; i < num; i++) {
			threads.add(new Thread(new EngineThread()));
		}
		run = true;
		for (Thread thread : threads) {
			thread.start();
		}
	}

	@Override
	public void stopEngine() {
		run = false;
		for (Thread thread : threads) {
			State s = thread.getState();
			switch (s) {
			case NEW:
				break;
			case RUNNABLE:
			case BLOCKED:
			case WAITING:
			case TIMED_WAITING:
				thread.interrupt();
				break;
			case TERMINATED:
				break;
			default:
				break;
			}
			while (true) {
				if (State.TERMINATED.equals(thread.getState())) {
					break;
				} else {
					synchronized (this) {
						try {
							wait(1000);
						} catch (InterruptedException e) {
							// pass
						}
					}
				}
			}
		}
	}

	@Override
	public void addRequest(IRequest request) {
		super.addRequest(request);
		unblock();
	}

	// ***********************************************************************//
	// private functions
	// ***********************************************************************//

	private void block() {
		try {
			synchronized (lock) {
				lock.wait();
			}
		} catch (InterruptedException e) {
			// pass
		}
	}

	private void unblock() {
		synchronized (lock) {
			lock.notifyAll();
		}
	}

	// ***********************************************************************//
	// internal class
	// ***********************************************************************//

	protected class EngineThread implements Runnable {

		private ISchedulerMiddleware schedulerMW;
		private IScheduler scheduler;
		private IDownloaderMiddleware downloaderMW;
		private IDownloader defaultDownloader;
		private IParserMiddleware parserMW;
		private IParser defaultParser;
		private IPipelineMiddleware pipelineMW;
		private IPipeline defaultPipeline;

		public EngineThread() {
			ICrawler crawler = getCrawler();
			schedulerMW = crawler.getSchedulerMiddleware();
			scheduler = crawler.getScheduler();
			downloaderMW = crawler.getDownloaderMiddleware();
			defaultDownloader = crawler.getDefaultDownloader();
			parserMW = crawler.getParserMiddleware();
			defaultParser = crawler.getDefaultParser();
			pipelineMW = crawler.getPipelineMiddleware();
			defaultPipeline = crawler.getDefaultPipeline();
		}

		@Override
		public void run() {
			while (run) {
				try {
					IRequest request = schedulerMW.getRequest(scheduler);
					if (request != null) {
						processRequest(request);
					} else {
						block();
					}
				} catch (IgnoreRequestException e) {
					continue;
				} catch (IgnoreResponseException e) {
					continue;
				} catch (Exception e) {
					getLogger().error(null, e);
				}
			}
		}

		private void processRequest(IRequest request) {
			// get downloader
			IDownloader downloader = request.hasDownloader() ? request
					.getDownloader() : defaultDownloader;
			// get parser
			IParser parser = request.hasParser() ? request.getParser()
					: defaultParser;
			// get pipeline
			IPipeline pipeline = request.hasPipeline() ? request.getPipeline()
					: defaultPipeline;
			// process
			for (IItem item : parserMW.parse(parser, request,
					downloaderMW.download(downloader, request))) {
				try {
					if (item instanceof NewRequestItem)
						addRequest(((NewRequestItem) item).getRequest());
					else
						pipelineMW.pipe(pipeline, item);
				} catch (Exception e) {
					getLogger().error(null, e);
				}
			}
		}

	}

}
