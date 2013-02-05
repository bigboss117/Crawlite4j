package cn.crawlite4j.engine;

import cn.crawlite4j.crawler.ICrawler;
import cn.crawlite4j.log.ILogger;
import cn.crawlite4j.request.IRequest;

public abstract class AbstractEngine implements IEngine {

	private ICrawler crawler;
	private ILogger logger;

	// ***********************************************************************//
	// Constructor
	// ***********************************************************************//

	public AbstractEngine() {

	}

	// ***********************************************************************//
	// abstract functions
	// ***********************************************************************//

	@Override
	public abstract void start();

	@Override
	public abstract void stop();

	// ***********************************************************************//
	// implemented functions
	// ***********************************************************************//

	@Override
	public final void setCrawler(ICrawler crawler) {
		this.crawler = crawler;
	}

	@Override
	public final ICrawler getCrawler() {
		return crawler;
	}
	
	@Override
	public final void setLogger(ILogger logger) {
		this.logger = logger;
	}
	
	@Override
	public final ILogger getLogger() {
		return logger;
	}
	
	@Override
	public void addRequest(IRequest request) {
		try {
			crawler.getSchedulerMiddleware().addRequest(crawler.getScheduler(), request);
		} catch (Exception e) {
			logger.error(null, e);
		}
	}

}
