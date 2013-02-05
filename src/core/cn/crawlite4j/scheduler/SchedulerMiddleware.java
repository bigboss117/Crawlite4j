package cn.crawlite4j.scheduler;

import cn.crawlite4j.request.IRequest;

public class SchedulerMiddleware extends AbstractSchedulerMiddleware {

	@Override
	protected IRequest processRequest(IRequest request) {
		if (request == null)
			throw new NullPointerException("request is null");
		return request;
	}

	@Override
	protected boolean requestSeen(IRequest request) {
		return false;
	}

	@Override
	protected void processAddException(RuntimeException e) {
		throw e;
	}

	@Override
	protected IRequest processGetException(RuntimeException e) {
		throw e;
	}

}
