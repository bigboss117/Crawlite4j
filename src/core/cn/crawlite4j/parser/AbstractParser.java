package cn.crawlite4j.parser;

import java.util.List;

import cn.crawlite4j.item.IItem;
import cn.crawlite4j.request.IRequest;
import cn.crawlite4j.response.IResponse;
import cn.crawlite4j.spider.ISpider;

public abstract class AbstractParser implements IParser {

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
	public abstract List<IItem> parseResponse(IRequest request,
			IResponse response);

}
