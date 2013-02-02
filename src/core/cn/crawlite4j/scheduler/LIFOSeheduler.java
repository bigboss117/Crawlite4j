package cn.crawlite4j.scheduler;

import java.util.LinkedList;

import cn.crawlite4j.request.IRequest;

public class LIFOSeheduler extends AbstractScheduler {

	protected LinkedList<IRequest> list = new LinkedList<IRequest>();

	@Override
	public synchronized IRequest getRequest() {
		return list.pollLast();
	}

	@Override
	protected synchronized void enqueueRequest(IRequest request) {
		list.offerLast(request);
	}

}
