package cn.crawlite4j.spider;

import cn.crawlite4j.downloader.IDownloader;
import cn.crawlite4j.engine.IEngine;
import cn.crawlite4j.log.ILogger;
import cn.crawlite4j.log.Level;
import cn.crawlite4j.parser.IParser;
import cn.crawlite4j.pipeline.IPipeline;
import cn.crawlite4j.request.IRequest;
import cn.crawlite4j.scheduler.IScheduler;

public abstract class AbstractSpider implements ISpider {

	protected ILogger logger;
	protected IScheduler scheduler;
	protected IDownloader defaultDownloader;
	protected IParser defaultParser;
	protected IPipeline defaultPipeline;

	protected IEngine engine;

	// ***********************************************************************//
	// Constructor
	// ***********************************************************************//

	protected AbstractSpider() {

	}

	// ***********************************************************************//
	// abstract functions
	// ***********************************************************************//

	public abstract void addSeed(Object seed);

	public abstract void startRequests();

	// ***********************************************************************//
	// implemented functions
	// ***********************************************************************//

	@Override
	public ILogger getLogger() {
		return logger;
	}

	@Override
	public void setLogger(ILogger logger) {
		this.logger = logger;
	}

	@Override
	public Level getLogLevel() {
		return logger.getLevel();
	}

	@Override
	public void setLogLevel(Level level) {
		logger.setLevel(level);
	}

	@Override
	public IScheduler getScheduler() {
		return scheduler;
	}

	@Override
	public void setScheduler(IScheduler scheduler) {
		scheduler.setSpider(this);
		this.scheduler = scheduler;
	}

	@Override
	public IDownloader getDefaultDownloader() {
		return defaultDownloader;
	}

	@Override
	public void setDefaultDownloader(IDownloader downloader) {
		downloader.setSpider(this);
		defaultDownloader = downloader;
	}

	@Override
	public IParser getDefaultParser() {
		return defaultParser;
	}

	@Override
	public void setDefaultParser(IParser parser) {
		parser.setSpider(this);
		defaultParser = parser;
	}

	@Override
	public IPipeline getDefaultPipeline() {
		return defaultPipeline;
	}

	@Override
	public void setDefaultPipeline(IPipeline pipeline) {
		pipeline.setSpider(this);
		defaultPipeline = pipeline;
	}

	@Override
	public void setEngine(IEngine engine) {
		engine.setSpider(this);
		this.engine = engine;
	}

	@Override
	public final void runSpider() {
		if (logger == null)
			throw new NullPointerException("logger is null");
		if (scheduler == null)
			throw new NullPointerException("scheduler is null");
		if (defaultDownloader == null)
			throw new NullPointerException("defaultDownloader is null");
		if (defaultParser == null)
			throw new NullPointerException("defaultParser is null");
		if (defaultPipeline == null)
			throw new NullPointerException("defaultPipeline is null");
		if (engine == null)
			throw new NullPointerException("engine is null");
		try {
			startRequests();
		} catch (Exception e) {
			logger.error(null, e);
		}
		engine.start();
	}

	@Override
	public void addRequest(IRequest request) {
		addRequestToScheduler(request);
	}

	@Override
	public IRequest getRequest() {
		return scheduler.getRequest();
	}

	// ***********************************************************************//
	// protected functions
	// ***********************************************************************//

	protected void addRequestToScheduler(IRequest request) {
		scheduler.addRequest(request);
	}

}
