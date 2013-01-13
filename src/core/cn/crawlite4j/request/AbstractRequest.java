package cn.crawlite4j.request;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import cn.crawlite4j.downloader.IDownloader;
import cn.crawlite4j.parser.IParser;
import cn.crawlite4j.pipeline.IPipeline;
import cn.crawlite4j.request.IRequest;

public abstract class AbstractRequest implements IRequest {
	
	private final String urlString;
	private int downloadTimeout;
	private static final TimeUnit downloadTimeoutTimeUnit = TimeUnit.MILLISECONDS;
	private HashMap<Object, Object> property = null;
	private IDownloader downloader = null;
	private IParser parser = null;
	private IPipeline pipeline = null;
	
	//Constructor
	public AbstractRequest(String url, int timeout) {
		this.urlString = url;
		this.downloadTimeout = timeout;
	}
	
	public AbstractRequest(String url) {
		this(url, 1000);
	}
	
	//implemented
	@Override
	public String getUrlString() {
		return urlString;
	}
	
	@Override
	public int getDownloadTimeout() {
		return downloadTimeout;
	}
	
	@Override
	public void setDownloadTimeout(int timeout) {
		downloadTimeout = timeout;
	}
	
	@Override
	public TimeUnit getDownloadTimeoutTimeUnit() {
		return downloadTimeoutTimeUnit;
	}
	
	@Override
	public boolean hasProperty(Object key) {
		if (property == null)
			return false;
		return property.containsKey(key);
	}
	
	@Override
	public Object getProperty(Object key) {
		if (property == null)
			return null;
		return property.get(key);
	}
	
	@Override
	public void setProperty(Object key, Object value) {
		if (property == null)
			property = new HashMap<Object, Object>();
		property.put(key, value);
	}

	@Override
	public boolean hasDownloader() {
		if (downloader == null)
			return false;
		return true;
	}

	@Override
	public IDownloader getDownloader() {
		return downloader;
	}

	@Override
	public boolean hasParser() {
		if (parser == null)
			return false;
		return true;
	}

	@Override
	public IParser getParser() {
		return parser;
	}

	@Override
	public boolean hasPipeline() {
		if (pipeline == null)
			return false;
		return true;
	}

	@Override
	public IPipeline getPipeline() {
		return pipeline;
	}
	
}
