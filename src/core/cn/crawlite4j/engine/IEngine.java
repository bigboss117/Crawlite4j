package cn.crawlite4j.engine;

import cn.crawlite4j.crawler.ICrawler;
import cn.crawlite4j.log.ILogger;
import cn.crawlite4j.request.IRequest;

public interface IEngine {

	public void setCrawler(ICrawler crawler);

	public ICrawler getCrawler();

	public void setLogger(ILogger logger);
	
	public ILogger getLogger();
	
	public void addRequest(IRequest request);
	
	public void start();

	public void stop();

}
