package cn.crawlite4j.core.scheduler;

import java.util.concurrent.LinkedBlockingDeque;

import cn.crawlite4j.core.request.IRequest;

public class LIFOBlockingScheduler extends AbstractScheduler {

	protected LinkedBlockingDeque<IRequest> blockDeque = new LinkedBlockingDeque<IRequest>();
	
	@Override
	public IRequest getRequest() {
		try {
			return blockDeque.takeLast();
		} catch (InterruptedException e) {
			throw new ScheduleException(null, e);
		}
	}

	@Override
	public void addRequest(IRequest request) {
		try {
			blockDeque.putLast(request);
		} catch (InterruptedException e) {
			throw new ScheduleException(null, e);
		}
	}

}
