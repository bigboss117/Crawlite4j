package cn.crawlite4j.parser;

import java.util.List;

import cn.crawlite4j.item.IItem;
import cn.crawlite4j.request.IRequest;
import cn.crawlite4j.response.IResponse;

public interface IParserMiddleware {

	public List<IItem> parse(IParser parser, IRequest request, IResponse response);

}
