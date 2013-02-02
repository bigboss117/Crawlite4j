package cn.crawlite4j.scheduler;

import cn.crawlite4j.request.IRequest;
import cn.crawlite4j.spider.ISpider;

public abstract class AbstractScheduler implements IScheduler {

	private ISpider spider;

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

	public abstract IRequest getRequest();

	protected abstract void enqueueRequest(IRequest request);

	// ***********************************************************************//
	// implemented functions
	// ***********************************************************************//

	@Override
	public void setSpider(ISpider spider) {
		this.spider = spider;
	}

	@Override
	public ISpider getSpider() {
		return spider;
	}

	@Override
	public void addRequest(IRequest request) {
		boolean seen = dupFilter.requestSeen(request, spider);
		if (seen && !request.dontFilter())
			spider.getLogger().debug(
					"Skipped (" + request.getUrlString() + ") already seen)");
		else
			enqueueRequest(request);
	}

	// ***********************************************************************//
	// public functions
	// ***********************************************************************//

}
