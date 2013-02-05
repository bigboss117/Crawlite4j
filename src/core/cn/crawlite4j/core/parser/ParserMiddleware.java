package cn.crawlite4j.core.parser;

import java.util.LinkedList;
import java.util.List;

import cn.crawlite4j.core.item.IItem;
import cn.crawlite4j.core.request.IRequest;
import cn.crawlite4j.core.response.IResponse;

public class ParserMiddleware extends AbstractParseMiddleware {

	@Override
	protected IResponse processResponse(IRequest request, IResponse response) {
		if (response == null)
			throw new NullPointerException("response is null");
		return response;
	}
	
	@Override
	protected List<IItem> processFailed(IRequest request, IResponse response) {
		return new LinkedList<IItem>();
	}
	
	@Override
	protected void matchParser(IParser parser, IRequest request, IResponse response) {
		if (!(response instanceof IRequest))
			throw new IllegalArgumentException("response is not a IRequest");
	}

	@Override
	protected List<IItem> processItem(List<IItem> itemList) {
		if (itemList == null)
			throw new NullPointerException("itemList is null");
		return itemList;
	}

	@Override
	protected List<IItem> processException(RuntimeException e) {
		throw e;
	}

}
