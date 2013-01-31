package cn.crawlite4j.scheduler;

import cn.crawlite4j.request.IRequest;
import cn.crawlite4j.spider.ISpider;

public abstract class AbstractDuplFilter implements IRequestDuplFilter {

	@Override
	public abstract boolean requestSeen(IRequest request, ISpider spider);

}
