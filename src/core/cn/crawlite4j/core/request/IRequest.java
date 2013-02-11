package cn.crawlite4j.core.request;

import java.util.concurrent.TimeUnit;

import cn.crawlite4j.core.downloader.IDownloader;
import cn.crawlite4j.core.parser.IParser;
import cn.crawlite4j.core.pipeline.IPipeline;

public interface IRequest {

	public String getUrlString();

	public boolean dontFilter();

	public int getDownloadTimeout();

	public void setDownloadTimeout(int timeout);

	public TimeUnit getDownloadTimeUnit();

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
