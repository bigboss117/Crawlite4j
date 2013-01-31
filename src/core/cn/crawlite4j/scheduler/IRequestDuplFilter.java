package cn.crawlite4j.scheduler;

import cn.crawlite4j.request.IRequest;
import cn.crawlite4j.spider.ISpider;

public interface IRequestDuplFilter {

	public boolean requestSeen(IRequest request, ISpider spider);

}
