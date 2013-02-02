package cn.crawlite4j.spider;

import cn.crawlite4j.downloader.IDownloader;
import cn.crawlite4j.engine.IEngine;
import cn.crawlite4j.log.ILogger;
import cn.crawlite4j.log.Level;
import cn.crawlite4j.parser.IParser;
import cn.crawlite4j.pipeline.IPipeline;
import cn.crawlite4j.request.IRequest;
import cn.crawlite4j.scheduler.IScheduler;

public interface ISpider {

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

	public void setEngine(IEngine engine);

	public void runSpider();

	public void addSeed(Object seed);

	public void startRequests();

	public void addRequest(IRequest request);

	public IRequest getRequest();

}
