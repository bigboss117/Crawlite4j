package cn.crawlite4j.scheduler;

import cn.crawlite4j.request.IRequest;
import cn.crawlite4j.spider.ISpider;

public abstract class AbstractScheduler implements IScheduler {

	protected IRequestDuplFilter dupFilter = new AllFalseDuplFilter();

	// ***********************************************************************//
	// Constructor
	// ***********************************************************************//

	public AbstractScheduler(IRequestDuplFilter dupFilter) {
		this.dupFilter = dupFilter;
	}

	public AbstractScheduler() {

	}

	// ***********************************************************************//
	// abstract functions
	// ***********************************************************************//

	public abstract IRequest getRequest(ISpider spider);

	protected abstract void enqueueRequest(IRequest request, ISpider spider);

	// ***********************************************************************//
	// implemented functions
	// ***********************************************************************//

	@Override
	public void addRequest(IRequest request, ISpider spider) {
		boolean seen = dupFilter.requestSeen(request, spider);
		if (seen && !request.dontFilter())
			spider.getLogger().debug(
					"Skipped (" + request.getUrlString() + ") already seen)");
		else
			enqueueRequest(request, spider);
	}

	// ***********************************************************************//
	// public functions
	// ***********************************************************************//

}
