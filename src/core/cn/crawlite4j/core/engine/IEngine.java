package cn.crawlite4j.core.engine;

import cn.crawlite4j.core.crawler.ICrawler;
import cn.crawlite4j.core.log.ILogger;
import cn.crawlite4j.core.request.IRequest;

public interface IEngine {

	public void setCrawler(ICrawler crawler);

	public ICrawler getCrawler();

	public void setLogger(ILogger logger);

	public ILogger getLogger();

	public void addRequest(IRequest request);

	public void startEngine();

	public void stopEngine();

}
