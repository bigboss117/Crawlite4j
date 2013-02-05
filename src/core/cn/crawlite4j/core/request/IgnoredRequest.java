package cn.crawlite4j.core.request;

import java.util.concurrent.TimeUnit;

import cn.crawlite4j.core.UnimplementFunctionException;
import cn.crawlite4j.core.downloader.IDownloader;
import cn.crawlite4j.core.parser.IParser;
import cn.crawlite4j.core.pipeline.IPipeline;

public class IgnoredRequest implements IRequest {

	@Override
	public String getUrlString() {
		throw new UnimplementFunctionException();
	}

	@Override
	public boolean dontFilter() {
		throw new UnimplementFunctionException();
	}

	@Override
	public int getDownloadTimeout() {
		throw new UnimplementFunctionException();
	}

	@Override
	public void setDownloadTimeout(int timeout) {
		throw new UnimplementFunctionException();
	}

	@Override
	public TimeUnit getDownloadTimeoutTimeUnit() {
		throw new UnimplementFunctionException();
	}

	@Override
	public boolean hasProperty(Object key) {
		throw new UnimplementFunctionException();
	}

	@Override
	public Object getProperty(Object key) {
		throw new UnimplementFunctionException();
	}

	@Override
	public void setProperty(Object key, Object value) {
		throw new UnimplementFunctionException();
	}

	@Override
	public boolean hasDownloader() {
		throw new UnimplementFunctionException();
	}

	@Override
	public IDownloader getDownloader() {
		throw new UnimplementFunctionException();
	}

	@Override
	public boolean hasParser() {
		throw new UnimplementFunctionException();
	}

	@Override
	public IParser getParser() {
		throw new UnimplementFunctionException();
	}

	@Override
	public boolean hasPipeline() {
		throw new UnimplementFunctionException();
	}

	@Override
	public IPipeline getPipeline() {
		throw new UnimplementFunctionException();
	}

}
