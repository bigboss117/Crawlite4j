package cn.crawlite4j.core.downloader;

import cn.crawlite4j.core.request.IRequest;
import cn.crawlite4j.core.response.IResponse;

public interface IDownloaderMiddleware {

	public IResponse download(IDownloader downloader, IRequest request);

}
