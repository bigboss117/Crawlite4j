package cn.crawlite4j.engine;

import java.util.ArrayList;
import java.util.List;

import cn.crawlite4j.crawler.ICrawler;
import cn.crawlite4j.downloader.IDownloader;
import cn.crawlite4j.downloader.IDownloaderMiddleware;
import cn.crawlite4j.item.IItem;
import cn.crawlite4j.item.NewRequestItem;
import cn.crawlite4j.parser.IParser;
import cn.crawlite4j.parser.IParserMiddleware;
import cn.crawlite4j.pipeline.IPipeline;
import cn.crawlite4j.pipeline.IPipelineMiddleware;
import cn.crawlite4j.request.IRequest;
import cn.crawlite4j.request.IgnoreRequestException;
import cn.crawlite4j.response.IResponse;
import cn.crawlite4j.response.IgnoreResponseException;
import cn.crawlite4j.scheduler.IScheduler;
import cn.crawlite4j.scheduler.ISchedulerMiddleware;

public class SimpleMutilThreadEngine extends AbstractEngine {

	protected List<Thread> threads;

	// ***********************************************************************//
	// Constructor
	// ***********************************************************************//

	public SimpleMutilThreadEngine(int threadNum) {
		super();
		threads = new ArrayList<Thread>(threadNum);
		for (int i = 0; i < threadNum; i++) {
			threads.add(new Thread(new EngineThread()));
		}
	}

	public SimpleMutilThreadEngine() {
		this(1);
	}

	// ***********************************************************************//
	// implemented functions
	// ***********************************************************************//

	@Override
	public void start() {
		for (Thread thread : threads) {
			thread.start();
		}
	}

	@Override
	public void stop() {
		for (Thread thread : threads) {
			thread.interrupt();
			getLogger().debug("Engine interrupt one thread.");
		}
	}

	// ***********************************************************************//
	// protected functions
	// ***********************************************************************//

	// ***********************************************************************//
	// internal class
	// ***********************************************************************//

	protected class EngineThread implements Runnable {

		@Override
		public void run() {
			ICrawler crwaler = getCrawler();
			IScheduler scheduler = crwaler.getScheduler();
			IDownloader defaultDownloader = crwaler.getDefaultDownloader();
			IParser defaultParser = crwaler.getDefaultParser();
			IPipeline defaultPipeline = crwaler.getDefaultPipeline();
			ISchedulerMiddleware schedulerMiddleware = crwaler.getSchedulerMiddleware();
			IDownloaderMiddleware downloaderMiddleware = crwaler.getDownloaderMiddleware();
			IParserMiddleware parserMiddleware = crwaler.getParserMiddleware();
			IPipelineMiddleware pipelineMiddleware = crwaler.getPipelineMiddleware();
			getLogger().debug("Engine start one thread.");
			while (true) {
				try {
					IRequest request = schedulerMiddleware.getRequest(scheduler);
					if (request != null) {
						// get downloader
						IDownloader downloader = null;
						if (request.hasDownloader())
							downloader = request.getDownloader();
						else
							downloader = defaultDownloader;
						// get parser
						IParser parser = null;
						if (request.hasParser())
							parser = request.getParser();
						else
							parser = defaultParser;
						// get pipeline
						IPipeline pipeline = null;
						if (request.hasPipeline())
							pipeline = request.getPipeline();
						else
							pipeline = defaultPipeline;
						//process
						IResponse response = downloaderMiddleware.download(downloader, request);
						List<IItem> itemList = parserMiddleware.parse(parser, request, response);
						for (IItem item : itemList) {
							if (item instanceof NewRequestItem)
								schedulerMiddleware.addRequest(scheduler, ((NewRequestItem)item).getRequest());
							else
								pipelineMiddleware.pipe(pipeline, item);
						}
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

	}

}
