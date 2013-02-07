package cn.crawlite4j.core.request;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import cn.crawlite4j.core.downloader.IDownloader;
import cn.crawlite4j.core.parser.IParser;
import cn.crawlite4j.core.pipeline.IPipeline;

public abstract class AbstractRequest implements IRequest {

	private final String urlString;
	private final boolean dontFilter;
	private int downloadTimeout;
	private static final TimeUnit downloadTimeoutTimeUnit = TimeUnit.MILLISECONDS;
	private HashMap<Object, Object> property = null;
	private IDownloader downloader = null;
	private IParser parser = null;
	private IPipeline pipeline = null;

	// Constructor
	public AbstractRequest(String url, int timeout, boolean dontFilter) {
		this.urlString = url;
		this.downloadTimeout = timeout;
		this.dontFilter = dontFilter;
	}

	public AbstractRequest(String url, int timeout) {
		this(url, 1000, false);
	}

	public AbstractRequest(String url) {
		this(url, 1000);
	}

	// implemented
	@Override
	public String getUrlString() {
		return urlString;
	}

	@Override
	public boolean dontFilter() {
		return dontFilter;
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
		return downloader != null;
	}

	@Override
	public IDownloader getDownloader() {
		return downloader;
	}

	@Override
	public boolean hasParser() {
		return parser != null;
	}

	@Override
	public IParser getParser() {
		return parser;
	}

	@Override
	public boolean hasPipeline() {
		return pipeline != null;
	}

	@Override
	public IPipeline getPipeline() {
		return pipeline;
	}

}
