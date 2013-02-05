package cn.crawlite4j.core.parser;

import java.util.List;

import cn.crawlite4j.core.item.IItem;
import cn.crawlite4j.core.log.ILogger;
import cn.crawlite4j.core.request.IRequest;
import cn.crawlite4j.core.response.IResponse;

public abstract class AbstractParser implements IParser {

	private ILogger logger;

	@Override
	public final void setLogger(ILogger logger) {
		this.logger = logger;
	}

	@Override
	public final ILogger getLogger() {
		return logger;
	}

	@Override
	public abstract List<IItem> parseResponse(IRequest request, IResponse response);

}
