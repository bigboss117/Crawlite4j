package cn.crawlite4j.scheduler;

import cn.crawlite4j.request.IRequest;
import cn.crawlite4j.spider.ISpider;

public interface IScheduler {

	public void setSpider(ISpider spider);

	public ISpider getSpider();

	public void addRequest(IRequest request);

	public IRequest getRequest();

}
