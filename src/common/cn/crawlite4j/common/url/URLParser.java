package cn.crawlite4j.common.url;

import java.util.ArrayList;
import java.util.List;

import cn.crawlite4j.item.IItem;
import cn.crawlite4j.parser.AbstractParser;
import cn.crawlite4j.request.IRequest;
import cn.crawlite4j.response.IResponse;

public class URLParser extends AbstractParser {

	@Override
	public List<IItem> parseResponse(IRequest request, IResponse response) {
		URLResponse r = (URLResponse) response;
		List<IItem> itemList = new ArrayList<IItem>();
		itemList.add(new URLItem(r.getContet()));
		return itemList;
	}

}
