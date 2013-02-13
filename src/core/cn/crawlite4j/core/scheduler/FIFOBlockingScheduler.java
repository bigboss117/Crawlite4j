package cn.crawlite4j.core.scheduler;

import java.util.concurrent.LinkedBlockingQueue;

import cn.crawlite4j.core.request.IRequest;

public class FIFOBlockingScheduler extends AbstractScheduler {
	
	protected LinkedBlockingQueue<IRequest> blockQueue = new LinkedBlockingQueue<IRequest>();

	@Override
	public IRequest getRequest() {
		try {
			return blockQueue.take();
		} catch (InterruptedException e) {
			throw new ScheduleException(null, e);
		}
	}

	@Override
	public void addRequest(IRequest request) {
		try {
			blockQueue.put(request);
		} catch (InterruptedException e) {
			throw new ScheduleException(null, e);
		}
	}

}
