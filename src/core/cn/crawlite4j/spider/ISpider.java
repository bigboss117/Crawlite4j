package cn.crawlite4j.spider;

import cn.crawlite4j.downloader.IDownloader;
import cn.crawlite4j.log.ILogger;
import cn.crawlite4j.parser.IParser;
import cn.crawlite4j.pipeline.IPipeline;
import cn.crawlite4j.request.IRequest;

public interface ISpider {

	public ILogger getLogger();

	public IDownloader getDefaultDownloader();

	public IParser getDefaultParser();

	public IPipeline getDefaultPipeline();

	public void addSeed(Object seed);

	public void startRequests();

	public void addRequest(IRequest request);

	public IRequest getRequest();

}
