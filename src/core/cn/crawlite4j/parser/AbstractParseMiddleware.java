package cn.crawlite4j.parser;

import java.util.List;

import cn.crawlite4j.item.IItem;
import cn.crawlite4j.request.IRequest;
import cn.crawlite4j.response.IResponse;

public abstract class AbstractParseMiddleware implements IParserMiddleware {

	@Override
	public final List<IItem> parse(IParser parser, IRequest request, IResponse response) {
		try {
			response = processResponse(request, response);
			List<IItem> itemList;
			if (response.isFailed())
				itemList = processFailed(request, response);
			else
				matchParser(parser, request, response);
				itemList = parser.parseResponse(request, response);
			return processItem(itemList);
		} catch (RuntimeException e) {
			return processException(e);
		}
	}

	protected abstract IResponse processResponse(IRequest request, IResponse response);
	
	protected abstract List<IItem> processFailed(IRequest request, IResponse response);
	
	protected abstract void matchParser(IParser parser, IRequest request, IResponse response);

	protected abstract List<IItem> processItem(List<IItem> itemList);

	protected abstract List<IItem> processException(RuntimeException e);

}
