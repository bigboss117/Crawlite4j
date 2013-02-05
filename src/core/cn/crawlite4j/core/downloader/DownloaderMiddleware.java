package cn.crawlite4j.core.downloader;

import cn.crawlite4j.core.request.IRequest;
import cn.crawlite4j.core.response.IResponse;

public class DownloaderMiddleware extends AbstractDownloaderMiddleware {

	@Override
	protected IRequest processRequest(IRequest request) {
		if (request == null)
			throw new NullPointerException("request is null");
		return request;
	}
	
	@Override
	protected void matchDownloader(IDownloader downloader, IRequest request) {
		if (!(request instanceof IRequest))
			throw new IllegalArgumentException("request is not a IRequest");
	}

	@Override
	protected IResponse processResponse(IResponse response) {
		if (response == null)
			throw new NullPointerException("response is null");
		return response;
	}

	@Override
	protected IResponse processException(RuntimeException e) {
		throw e;
	}

}
