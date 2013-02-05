package cn.crawlite4j.core.scheduler;

import cn.crawlite4j.core.log.ILogger;
import cn.crawlite4j.core.request.IRequest;

public interface IScheduler {

	public void setLogger(ILogger logger);

	public ILogger getLogger();

	public void addRequest(IRequest request);

	public IRequest getRequest();

}
