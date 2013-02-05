package cn.crawlite4j.core.downloader;

import cn.crawlite4j.core.log.ILogger;
import cn.crawlite4j.core.request.IRequest;
import cn.crawlite4j.core.response.IResponse;

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
