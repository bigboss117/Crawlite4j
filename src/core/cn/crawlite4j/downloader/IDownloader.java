package cn.crawlite4j.downloader;

import cn.crawlite4j.request.IRequest;
import cn.crawlite4j.response.IResponse;
import cn.crawlite4j.spider.ISpider;

public interface IDownloader {
	public IResponse downloadRequest(IRequest request, ISpider spider);
}
