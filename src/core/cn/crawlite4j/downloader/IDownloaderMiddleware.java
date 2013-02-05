package cn.crawlite4j.downloader;

import cn.crawlite4j.request.IRequest;
import cn.crawlite4j.response.IResponse;

public interface IDownloaderMiddleware {

	public IResponse download(IDownloader downloader, IRequest request);

}
