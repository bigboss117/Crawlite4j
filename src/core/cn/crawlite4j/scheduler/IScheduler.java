package cn.crawlite4j.scheduler;

import cn.crawlite4j.log.ILogger;
import cn.crawlite4j.request.IRequest;

public interface IScheduler {

	public void setLogger(ILogger logger);

	public ILogger getLogger();

	public void addRequest(IRequest request);

	public IRequest getRequest();

}
