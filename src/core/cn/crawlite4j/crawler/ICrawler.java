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
import cn.crawlite4j.scheduler.IScheduler;
import cn.crawlite4j.scheduler.ISchedulerMiddleware;

public interface ICrawler {

	public ILogger getLogger();

	public void setLogger(ILogger logger);

	public Level getLogLevel();

	public void setLogLevel(Level level);

	public IScheduler getScheduler();

	public void setScheduler(IScheduler scheduler);

	public IDownloader getDefaultDownloader();

	public void setDefaultDownloader(IDownloader downloader);

	public IParser getDefaultParser();

	public void setDefaultParser(IParser parser);

	public IPipeline getDefaultPipeline();

	public void setDefaultPipeline(IPipeline pipeline);

	public void setSchedulerMiddleware(ISchedulerMiddleware middleware);

	public ISchedulerMiddleware getSchedulerMiddleware();

	public void setDownloaderMiddleware(IDownloaderMiddleware middleware);

	public IDownloaderMiddleware getDownloaderMiddleware();

	public void setParserMiddleware(IParserMiddleware middleware);

	public IParserMiddleware getParserMiddleware();

	public void setPipelineMiddleware(IPipelineMiddleware middleware);

	public IPipelineMiddleware getPipelineMiddleware();

	public void setEngine(IEngine engine);

	public void runSpider();

	public void addSeed(Object seed);

	public void startRequests();

}
