package cn.crawlite4j.engine;

import java.util.ArrayList;
import java.util.List;

import cn.crawlite4j.downloader.IDownloader;
import cn.crawlite4j.item.IItem;
import cn.crawlite4j.parser.IParser;
import cn.crawlite4j.pipeline.IPipeline;
import cn.crawlite4j.request.IRequest;
import cn.crawlite4j.response.IResponse;
import cn.crawlite4j.spider.ISpider;

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
			getSpider().getLogger().debug("Engine interrupt one thread.");
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
			ISpider spider = getSpider();
			IDownloader defaultDownloader = spider.getDefaultDownloader();
			IParser defaultParser = spider.getDefaultParser();
			IPipeline defaultPipeline = spider.getDefaultPipeline();
			spider.getLogger().debug("Engine start one thread.");
			while (true) {
				try {
					IRequest request = spider.getRequest();
					if (request != null) {
						// get downloader
						IDownloader downloader = null;
						if (request.hasDownloader())
							downloader = request.getDownloader();
						else
							downloader = defaultDownloader;
						if (downloader == null)
							throw new NullPointerException("downloader is null");
						// get parser
						IParser parser = null;
						if (request.hasParser())
							parser = request.getParser();
						else
							parser = defaultParser;
						if (parser == null)
							throw new NullPointerException("parser is null");
						// get pipeline
						IPipeline pipeline = null;
						if (request.hasPipeline())
							pipeline = request.getPipeline();
						else
							pipeline = defaultPipeline;
						if (pipeline == null)
							throw new NullPointerException("pipeline is null");
						//
						IResponse response = downloader
								.downloadRequest(request);
						List<IItem> itemList = parser.parseResponse(request,
								response);
						pipeline.processItem(itemList);
					}
				} catch (Exception e) {
					spider.getLogger().error(null, e);
				}
			}
		}

	}

}
