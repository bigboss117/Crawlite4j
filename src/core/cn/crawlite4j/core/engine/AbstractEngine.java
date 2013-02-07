package cn.crawlite4j.core.engine;

import cn.crawlite4j.core.crawler.ICrawler;
import cn.crawlite4j.core.log.ILogger;
import cn.crawlite4j.core.request.IRequest;
import cn.crawlite4j.core.request.IgnoreRequestException;
import cn.crawlite4j.core.scheduler.IScheduler;
import cn.crawlite4j.core.scheduler.ISchedulerMiddleware;

public abstract class AbstractEngine implements IEngine {

	private ICrawler crawler;
	private ILogger logger;

	protected ISchedulerMiddleware schedulerMW;
	protected IScheduler scheduler;

	// ***********************************************************************//
	// Constructor
	// ***********************************************************************//

	public AbstractEngine() {

	}

	// ***********************************************************************//
	// abstract functions
	// ***********************************************************************//

	@Override
	public abstract void startEngine();

	@Override
	public abstract void stopEngine();

	// ***********************************************************************//
	// implemented functions
	// ***********************************************************************//

	@Override
	public final void setCrawler(ICrawler crawler) {
		this.crawler = crawler;
		schedulerMW = crawler.getSchedulerMiddleware();
		scheduler = crawler.getScheduler();
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
			schedulerMW.addRequest(scheduler, request);
		} catch (IgnoreRequestException e) {
			// pass
		} catch (Exception e) {
			logger.error(null, e);
		}
	}

}
