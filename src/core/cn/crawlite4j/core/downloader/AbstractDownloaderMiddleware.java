package cn.crawlite4j.core.downloader;

import cn.crawlite4j.core.request.IRequest;
import cn.crawlite4j.core.response.IResponse;

public abstract class AbstractDownloaderMiddleware implements
		IDownloaderMiddleware {

	@Override
	public final IResponse download(IDownloader downloader, IRequest request) {
		try {
			request = processRequest(request);
			matchDownloader(downloader, request);
			return processResponse(downloader.downloadRequest(request));
		} catch (RuntimeException e) {
			return processException(e);
		}
	}

	protected abstract IRequest processRequest(IRequest request);

	protected abstract void matchDownloader(IDownloader downloader,
			IRequest request);

	protected abstract IResponse processResponse(IResponse response);

	protected abstract IResponse processException(RuntimeException e);

}
