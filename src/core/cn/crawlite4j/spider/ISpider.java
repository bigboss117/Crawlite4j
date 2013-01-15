package cn.crawlite4j.spider;

import cn.crawlite4j.downloader.IDownloader;
import cn.crawlite4j.log.ILogger;
import cn.crawlite4j.parser.IParser;
import cn.crawlite4j.pipeline.IPipeline;

public interface ISpider {
	public String getUuid();
	public ILogger getLogger();
	public IDownloader getDefaultDownloader();
	public IParser getDefaultParser();
	public IPipeline getDefaultPipeline();
	
	public abstract void addSeed(Object seed);
	public abstract void startRequests();
}
