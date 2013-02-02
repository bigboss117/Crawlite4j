package cn.crawlite4j.parser;

import java.util.List;

import cn.crawlite4j.item.IItem;
import cn.crawlite4j.request.IRequest;
import cn.crawlite4j.response.IResponse;
import cn.crawlite4j.spider.ISpider;

public interface IParser {

	public void setSpider(ISpider spider);

	public ISpider getSpider();

	public List<IItem> parseResponse(IRequest request, IResponse response);

}
