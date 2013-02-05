package cn.crawlite4j.core.parser;

import java.util.List;

import cn.crawlite4j.core.item.IItem;
import cn.crawlite4j.core.request.IRequest;
import cn.crawlite4j.core.response.IResponse;

public interface IParserMiddleware {

	public List<IItem> parse(IParser parser, IRequest request, IResponse response);

}
