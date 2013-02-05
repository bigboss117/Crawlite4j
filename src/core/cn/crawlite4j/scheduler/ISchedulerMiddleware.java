package cn.crawlite4j.scheduler;

import cn.crawlite4j.request.IRequest;

public interface ISchedulerMiddleware {

	public void addRequest(IScheduler scheduler, IRequest request);

	public IRequest getRequest(IScheduler scheduler);

}
