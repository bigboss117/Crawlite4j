package cn.crawlite4j.core.downloader;

import cn.crawlite4j.core.log.ILogger;
import cn.crawlite4j.core.request.IRequest;
import cn.crawlite4j.core.response.IResponse;

public interface IDownloader {

	public void setLogger(ILogger logger);

	public ILogger getLogger();

	public IResponse downloadRequest(IRequest request);

}
