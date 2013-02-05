package cn.crawlite4j.core.response;

import cn.crawlite4j.core.UnimplementFunctionException;

public class IgnoredResponse implements IResponse {

	@Override
	public String getUrlString() {
		throw new UnimplementFunctionException();
	}

	@Override
	public boolean isFailed() {
		throw new UnimplementFunctionException();
	}

	@Override
	public void setFailed(boolean failed) {
		throw new UnimplementFunctionException();
	}

	@Override
	public boolean getFailed() {
		throw new UnimplementFunctionException();
	}

}
