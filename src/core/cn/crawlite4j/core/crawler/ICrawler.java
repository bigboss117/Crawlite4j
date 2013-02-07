package cn.crawlite4j.core.crawler;

import cn.crawlite4j.core.downloader.IDownloader;
import cn.crawlite4j.core.downloader.IDownloaderMiddleware;
import cn.crawlite4j.core.engine.IEngine;
import cn.crawlite4j.core.log.ILogger;
import cn.crawlite4j.core.log.Level;
import cn.crawlite4j.core.parser.IParser;
import cn.crawlite4j.core.parser.IParserMiddleware;
import cn.crawlite4j.core.pipeline.IPipeline;
import cn.crawlite4j.core.pipeline.IPipelineMiddleware;
import cn.crawlite4j.core.scheduler.IScheduler;
import cn.crawlite4j.core.scheduler.ISchedulerMiddleware;

public interface ICrawler {

	public ILogger getLogger();

	public void setLogger(ILogger logger);

	public Level getLogLevel();

	public void setLogLevel(Level level);

	public void setSchedulerMiddleware(ISchedulerMiddleware middleware);

	public ISchedulerMiddleware getSchedulerMiddleware();

	public void setDownloaderMiddleware(IDownloaderMiddleware middleware);

	public IDownloaderMiddleware getDownloaderMiddleware();

	public void setParserMiddleware(IParserMiddleware middleware);

	public IParserMiddleware getParserMiddleware();

	public void setPipelineMiddleware(IPipelineMiddleware middleware);

	public IPipelineMiddleware getPipelineMiddleware();

	public IScheduler getScheduler();

	public void setScheduler(IScheduler scheduler);

	public IDownloader getDefaultDownloader();

	public void setDefaultDownloader(IDownloader downloader);

	public IParser getDefaultParser();

	public void setDefaultParser(IParser parser);

	public IPipeline getDefaultPipeline();

	public void setDefaultPipeline(IPipeline pipeline);

	public void setEngine(IEngine engine);

	public void runCrawler();

	public void stopCrawler();

	public void addSeed(Object seed);

	public void startRequests();

}
