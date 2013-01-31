package cn.crawlite4j.scheduler;

import java.util.LinkedList;

import cn.crawlite4j.request.IRequest;
import cn.crawlite4j.spider.ISpider;

public class LIFOSeheduler extends AbstractScheduler {

	protected LinkedList<IRequest> list = new LinkedList<IRequest>();

	@Override
	public synchronized IRequest getRequest(ISpider spider) {
		return list.pollLast();
	}

	@Override
	protected synchronized void enqueueRequest(IRequest request, ISpider spider) {
		list.offerLast(request);
	}

}
