package cn.crawlite4j.downloader;

import cn.crawlite4j.log.ILogger;
import cn.crawlite4j.request.IRequest;
import cn.crawlite4j.response.IResponse;

public interface IDownloader {

	public void setLogger(ILogger logger);

	public ILogger getLogger();

	public IResponse downloadRequest(IRequest request);

}
