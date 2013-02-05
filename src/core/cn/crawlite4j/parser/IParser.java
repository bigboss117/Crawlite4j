package cn.crawlite4j.parser;

import java.util.List;

import cn.crawlite4j.item.IItem;
import cn.crawlite4j.log.ILogger;
import cn.crawlite4j.request.IRequest;
import cn.crawlite4j.response.IResponse;

public interface IParser {

	public void setLogger(ILogger logger);

	public ILogger getLogger();

	public List<IItem> parseResponse(IRequest request, IResponse response);

}
