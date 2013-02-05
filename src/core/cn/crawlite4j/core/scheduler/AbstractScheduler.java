package cn.crawlite4j.core.scheduler;

import cn.crawlite4j.core.log.ILogger;
import cn.crawlite4j.core.request.IRequest;

public abstract class AbstractScheduler implements IScheduler {

	private ILogger logger;

	// ***********************************************************************//
	// Constructor
	// ***********************************************************************//

	public AbstractScheduler() {

	}

	// ***********************************************************************//
	// abstract functions
	// ***********************************************************************//

	public abstract IRequest getRequest();

	public abstract void addRequest(IRequest request);

	// ***********************************************************************//
	// implemented functions
	// ***********************************************************************//

	@Override
	public void setLogger(ILogger logger) {
		this.logger = logger;
	}

	@Override
	public ILogger getLogger() {
		return logger;
	}

	// ***********************************************************************//
	// public functions
	// ***********************************************************************//

}
