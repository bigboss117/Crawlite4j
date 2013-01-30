package cn.crawlite4j.parser;

import cn.crawlite4j.request.IRequest;
import cn.crawlite4j.response.IResponse;
import cn.crawlite4j.spider.ISpider;

public interface IParser {

	public void parseResponse(IRequest request, IResponse response,
			ISpider spider);

}
