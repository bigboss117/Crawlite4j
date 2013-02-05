package cn.crawlite4j.core.scheduler;

import cn.crawlite4j.core.request.IRequest;

public interface ISchedulerMiddleware {

	public void addRequest(IScheduler scheduler, IRequest request);

	public IRequest getRequest(IScheduler scheduler);

}
