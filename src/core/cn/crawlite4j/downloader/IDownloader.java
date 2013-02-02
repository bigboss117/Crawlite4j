package cn.crawlite4j.downloader;

import cn.crawlite4j.request.IRequest;
import cn.crawlite4j.response.IResponse;
import cn.crawlite4j.spider.ISpider;

public interface IDownloader {

	public void setSpider(ISpider spider);

	public ISpider getSpider();

	public IResponse downloadRequest(IRequest request);

}
