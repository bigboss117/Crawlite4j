package cn.crawlite4j.downloader;

import cn.crawlite4j.request.IRequest;
import cn.crawlite4j.response.IResponse;
import cn.crawlite4j.spider.ISpider;

public abstract class AbstractDownloader implements IDownloader {

	private ISpider spider;

	@Override
	public final void setSpider(ISpider spider) {
		this.spider = spider;
	}

	@Override
	public final ISpider getSpider() {
		return spider;
	}

	@Override
	public abstract IResponse downloadRequest(IRequest request);

}
