package cn.crawlite4j.spider;

import cn.crawlite4j.downloader.IDownloader;
import cn.crawlite4j.log.ILogger;
import cn.crawlite4j.log.Level;
import cn.crawlite4j.log.SimpleConsoleLogger;
import cn.crawlite4j.parser.IParser;
import cn.crawlite4j.pipeline.IPipeline;
import cn.crawlite4j.request.IRequest;
import cn.crawlite4j.scheduler.IScheduler;

public abstract class AbstractSpider implements ISpider {

	protected final ILogger logger = intiLogger();
	protected IScheduler scheduler;
	protected IDownloader defaultDownloader;
	protected IParser defaultParser;
	protected IPipeline defaultPipeline;

	// ***********************************************************************//
	// Constructor
	// ***********************************************************************//

	protected AbstractSpider(IScheduler scheduler, IDownloader downloader,
			IParser parser, IPipeline pipeline, int threadNum, Level logLevel) {
		if (logLevel != null)
			logger.setLevel(logLevel);

		this.scheduler = scheduler;
		defaultDownloader = downloader;
		defaultParser = parser;
		defaultPipeline = pipeline;
	}

	// ***********************************************************************//
	// abstract functions
	// ***********************************************************************//

	public abstract void addSeed(Object seed);

	public abstract void startRequests();

	// ***********************************************************************//
	// implemented functions
	// ***********************************************************************//

	@Override
	public ILogger getLogger() {
		return logger;
	}

	@Override
	public IDownloader getDefaultDownloader() {
		return defaultDownloader;
	}

	@Override
	public IParser getDefaultParser() {
		return defaultParser;
	}

	@Override
	public IPipeline getDefaultPipeline() {
		return defaultPipeline;
	}

	@Override
	public void addRequest(IRequest request) {
		addRequestToScheduler(request);
	}

	@Override
	public IRequest getRequest() {
		return scheduler.getRequest(this);
	}

	// ***********************************************************************//
	// protected functions
	// ***********************************************************************//

	protected ILogger intiLogger() {
		return new SimpleConsoleLogger();
	}

	protected void addRequestToScheduler(IRequest request) {
		scheduler.addRequest(request, this);
	}

}
