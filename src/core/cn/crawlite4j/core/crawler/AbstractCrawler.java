package cn.crawlite4j.core.crawler;

import cn.crawlite4j.core.downloader.DownloaderMiddleware;
import cn.crawlite4j.core.downloader.IDownloader;
import cn.crawlite4j.core.downloader.IDownloaderMiddleware;
import cn.crawlite4j.core.engine.IEngine;
import cn.crawlite4j.core.log.ILogger;
import cn.crawlite4j.core.log.Level;
import cn.crawlite4j.core.parser.IParser;
import cn.crawlite4j.core.parser.IParserMiddleware;
import cn.crawlite4j.core.parser.ParserMiddleware;
import cn.crawlite4j.core.pipeline.IPipeline;
import cn.crawlite4j.core.pipeline.IPipelineMiddleware;
import cn.crawlite4j.core.pipeline.PipelineMiddleware;
import cn.crawlite4j.core.request.IRequest;
import cn.crawlite4j.core.request.IgnoreRequestException;
import cn.crawlite4j.core.scheduler.IScheduler;
import cn.crawlite4j.core.scheduler.ISchedulerMiddleware;
import cn.crawlite4j.core.scheduler.SchedulerMiddleware;

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
	public IScheduler getScheduler() {
		return scheduler;
	}

	@Override
	public void setScheduler(IScheduler scheduler) {
		this.scheduler = scheduler;
	}

	@Override
	public IDownloader getDefaultDownloader() {
		return defaultDownloader;
	}

	@Override
	public void setDefaultDownloader(IDownloader downloader) {
		defaultDownloader = downloader;
	}

	@Override
	public IParser getDefaultParser() {
		return defaultParser;
	}

	@Override
	public void setDefaultParser(IParser parser) {
		defaultParser = parser;
	}

	@Override
	public IPipeline getDefaultPipeline() {
		return defaultPipeline;
	}

	@Override
	public void setDefaultPipeline(IPipeline pipeline) {
		defaultPipeline = pipeline;
	}

	@Override
	public void setEngine(IEngine engine) {
		this.engine = engine;
	}

	@Override
	public final void runCrawler() {
		if (logger == null)
			throw new NullPointerException("logger is null");
		try {
			if (schedulerMiddleware == null) {
				schedulerMiddleware = new SchedulerMiddleware();
				logger.warn("Crawler member schedulerMiddleware is null, use default SchedulerMiddleware instead.");
			}
			if (downloaderMiddleware == null) {
				downloaderMiddleware = new DownloaderMiddleware();
				logger.warn("Crawler member downloaderMiddleware is null, use default DownloaderMiddleware instead.");
			}
			if (parserMiddleware == null) {
				parserMiddleware = new ParserMiddleware();
				logger.warn("Crawler member parserMiddleware is null, use default ParserMiddleware instead.");
			}
			if (pipelineMiddleware == null) {
				pipelineMiddleware = new PipelineMiddleware();
				logger.warn("Crawler member pipelineMiddleware is null, use default PipelineMiddleware instead.");
			}
			if (scheduler == null)
				throw new NullPointerException("scheduler is null");
			else
				scheduler.setLogger(logger);
			if (defaultDownloader == null)
				logger.warn("Crawler member defaultDownloader is null.");
			else
				defaultDownloader.setLogger(logger);
			if (defaultParser == null)
				logger.warn("Crawler member defaultParser is null.");
			else
				defaultParser.setLogger(logger);
			if (defaultPipeline == null)
				logger.warn("Crawler member defaultPipeline is null.");
			else
				defaultPipeline.setLogger(logger);
			if (engine == null)
				throw new NullPointerException("engine is null");
			else
				engine.setLogger(logger);
			engine.setCrawler(this);
			startRequests();
			logger.info("Start crawler.");
			engine.startEngine();
		} catch (Exception e) {
			logger.error(null, e);
		}
	}

	@Override
	public final void stopCrawler() {
		engine.stopEngine();
		logger.info("Stop crawler.");
	}

	// ***********************************************************************//
	// protected functions
	// ***********************************************************************//

	protected void addRequest(IRequest request) {
		try {
			schedulerMiddleware.addRequest(scheduler, request);
		} catch (IgnoreRequestException e) {
			// pass
		} catch (Exception e) {
			logger.error(null, e);
		}
	}

}
