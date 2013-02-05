package cn.crawlite4j.response;

import cn.crawlite4j.UnimplementFunctionException;

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
