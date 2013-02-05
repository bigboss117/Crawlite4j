package cn.crawlite4j.scheduler;

import cn.crawlite4j.request.IRequest;
import cn.crawlite4j.request.IgnoreRequestException;

public abstract class AbstractSchedulerMiddleware implements
		ISchedulerMiddleware {

	@Override
	public void addRequest(IScheduler scheduler, IRequest request) {
		try {
			IRequest r = processRequest(request);
			if (requestSeen(r) && !r.dontFilter())
				throw new IgnoreRequestException("Skipped (" + r.getUrlString()
						+ ") already seen)");
			else
				scheduler.addRequest(r);
		} catch (RuntimeException e) {
			processAddException(e);
		}

	}

	@Override
	public IRequest getRequest(IScheduler scheduler) {
		try {
			return scheduler.getRequest();
		} catch (RuntimeException e) {
			return processGetException(e);
		}

	}

	protected abstract IRequest processRequest(IRequest request);

	protected abstract boolean requestSeen(IRequest request);

	protected abstract void processAddException(RuntimeException e);

	protected abstract IRequest processGetException(RuntimeException e);

}
