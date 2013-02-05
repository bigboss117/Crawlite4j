package cn.crawlite4j.downloader;

import cn.crawlite4j.log.ILogger;
import cn.crawlite4j.request.IRequest;
import cn.crawlite4j.response.IResponse;

public abstract class AbstractDownloader implements IDownloader {

	private ILogger logger;

	@Override
	public final void setLogger(ILogger logger) {
		this.logger = logger;
	}

	@Override
	public final ILogger getLogger() {
		return logger;
	}

	@Override
	public abstract IResponse downloadRequest(IRequest request);

}
