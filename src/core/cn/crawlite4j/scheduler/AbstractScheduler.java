package cn.crawlite4j.scheduler;

import cn.crawlite4j.log.ILogger;
import cn.crawlite4j.request.IRequest;

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
