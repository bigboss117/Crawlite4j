package cn.crawlite4j.parser;

import java.util.ArrayList;
import java.util.List;

import cn.crawlite4j.item.IItem;
import cn.crawlite4j.item.SimpleItem;
import cn.crawlite4j.request.IRequest;
import cn.crawlite4j.response.IResponse;
import cn.crawlite4j.response.SimpleResponse;

public class SimpleParser extends AbstractParser {

	@Override
	public List<IItem> parseResponse(IRequest request, IResponse response) {
		if (!(request instanceof IRequest))
			throw new IllegalArgumentException("request is not a IRequest");
		if (!(response instanceof SimpleResponse))
			throw new IllegalArgumentException(
					"response is not a SimpleResponse");
		SimpleResponse r = (SimpleResponse) response;
		List<IItem> itemList = new ArrayList<IItem>();
		if (r.isSuccessful()) {
			itemList.add(new SimpleItem(r.getContet()));
		}
		return itemList;
	}

}
