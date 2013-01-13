package cn.crawlite4j.downloader;

import cn.crawlite4j.request.IRequest;
import cn.crawlite4j.response.IResponse;
import cn.crawlite4j.spider.ISpider;

public abstract class AbstractDownloader implements IDownloader {

	public abstract IResponse downloadRequest(IRequest request, 
			ISpider spider);

}
