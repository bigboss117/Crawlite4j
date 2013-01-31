package cn.crawlite4j.scheduler;

import cn.crawlite4j.request.IRequest;
import cn.crawlite4j.spider.ISpider;

public interface IScheduler {

	public void addRequest(IRequest request, ISpider spider);

	public IRequest getRequest(ISpider spider);

}
