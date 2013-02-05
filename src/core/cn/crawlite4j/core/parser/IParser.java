package cn.crawlite4j.core.parser;

import java.util.List;

import cn.crawlite4j.core.item.IItem;
import cn.crawlite4j.core.log.ILogger;
import cn.crawlite4j.core.request.IRequest;
import cn.crawlite4j.core.response.IResponse;

public interface IParser {

	public void setLogger(ILogger logger);

	public ILogger getLogger();

	public List<IItem> parseResponse(IRequest request, IResponse response);

}
