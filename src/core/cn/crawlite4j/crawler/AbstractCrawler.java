package cn.crawlite4j.crawler;

import cn.crawlite4j.downloader.IDownloader;
import cn.crawlite4j.downloader.IDownloaderMiddleware;
import cn.crawlite4j.engine.IEngine;
import cn.crawlite4j.log.ILogger;
import cn.crawlite4j.log.Level;
import cn.crawlite4j.parser.IParser;
import cn.crawlite4j.parser.IParserMiddleware;
import cn.crawlite4j.pipeline.IPipeline;
import cn.crawlite4j.pipeline.IPipelineMiddleware;
import cn.crawlite4j.request.IRequest;
import cn.crawlite4j.scheduler.IScheduler;
import cn.crawlite4j.scheduler.ISchedulerMiddleware;

public abstract class AbstractCrawler implements ICrawler {

	protected IScheduler scheduler;
	protected IDownloader defaultDownloader;
	protected IParser defaultParser;
	protected IPipeline defaultPipeline;

	protected ISchedulerMiddleware schedulerMiddleware;
	protected IDownloaderMiddleware downloaderMiddleware;
	protected IParserMiddleware parserMiddleware;
	protected IPipelineMiddleware pipelineMiddleware;

	protected IEngine engine;

	private ILogger logger;

	// ***********************************************************************//
	// Constructor
	// ***********************************************************************//

	protected AbstractCrawler() {

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
		scheduler.setLogger(logger);
		this.scheduler = scheduler;
	}

	@Override
	public IDownloader getDefaultDownloader() {
		return defaultDownloader;
	}

	@Override
	public void setDefaultDownloader(IDownloader downloader) {
		downloader.setLogger(logger);
		defaultDownloader = downloader;
	}

	@Override
	public IParser getDefaultParser() {
		return defaultParser;
	}

	@Override
	public void setDefaultParser(IParser parser) {
		parser.setLogger(logger);
		defaultParser = parser;
	}

	@Override
	public IPipeline getDefaultPipeline() {
		return defaultPipeline;
	}

	@Override
	public void setDefaultPipeline(IPipeline pipeline) {
		pipeline.setLogger(logger);
		defaultPipeline = pipeline;
	}

	@Override
	public ISchedulerMiddleware getSchedulerMiddleware() {
		return schedulerMiddleware;
	}

	@Override
	public void setSchedulerMiddleware(ISchedulerMiddleware middleware) {
		schedulerMiddleware = middleware;
	}

	@Override
	public IDownloaderMiddleware getDownloaderMiddleware() {
		return downloaderMiddleware;
	}

	@Override
	public void setDownloaderMiddleware(IDownloaderMiddleware middleware) {
		downloaderMiddleware = middleware;
	}

	@Override
	public IParserMiddleware getParserMiddleware() {
		return parserMiddleware;
	}

	@Override
	public void setParserMiddleware(IParserMiddleware middleware) {
		parserMiddleware = middleware;
	}

	@Override
	public IPipelineMiddleware getPipelineMiddleware() {
		return pipelineMiddleware;
	}

	@Override
	public void setPipelineMiddleware(IPipelineMiddleware middleware) {
		pipelineMiddleware = middleware;
	}

	@Override
	public void setEngine(IEngine engine) {
		engine.setCrawler(this);
		engine.setLogger(logger);
		this.engine = engine;
	}

	@Override
	public final void runSpider() {
		if (logger == null)
			throw new NullPointerException("logger is null");
		if (scheduler == null)
			throw new NullPointerException("defaultScheduler is null");
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

	// ***********************************************************************//
	// protected functions
	// ***********************************************************************//
	
	protected void addRequest(IRequest request) {
		engine.addRequest(request);
	}

}
