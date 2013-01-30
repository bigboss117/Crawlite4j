package cn.crawlite4j.scheduler;

import cn.crawlite4j.request.IRequest;

public interface IScheduler {

	public void addRequest(IRequest request);

	public IRequest getRequest();

}
