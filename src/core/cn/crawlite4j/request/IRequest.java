package cn.crawlite4j.request;

import java.util.concurrent.TimeUnit;

import cn.crawlite4j.downloader.IDownloader;
import cn.crawlite4j.parser.IParser;
import cn.crawlite4j.pipeline.IPipeline;

public interface IRequest {

	public String getUrlString();

	public boolean dontFilter();

	public int getDownloadTimeout();

	public void setDownloadTimeout(int timeout);

	public TimeUnit getDownloadTimeoutTimeUnit();

	public boolean hasProperty(Object key);

	public Object getProperty(Object key);

	public void setProperty(Object key, Object value);

	public boolean hasDownloader();

	public IDownloader getDownloader();

	public boolean hasParser();

	public IParser getParser();

	public boolean hasPipeline();

	public IPipeline getPipeline();

}
