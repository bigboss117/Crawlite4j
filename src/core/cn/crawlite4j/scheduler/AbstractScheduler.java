package cn.crawlite4j.scheduler;

import cn.crawlite4j.request.IRequest;

public abstract class AbstractScheduler implements IScheduler {

	public abstract void addRequest(IRequest request);

	public abstract IRequest getRequest();

}
