package cn.crawlite4j.scheduler;

import java.util.LinkedList;

import cn.crawlite4j.request.IRequest;

public class FIFOScheduler extends AbstractScheduler {

	protected LinkedList<IRequest> list = new LinkedList<IRequest>();

	@Override
	public synchronized IRequest getRequest() {
		return list.pollFirst();
	}

	@Override
	public synchronized void addRequest(IRequest request) {
		list.offerLast(request);
	}

}
