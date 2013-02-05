package cn.crawlite4j.core.response;

public interface IResponse {

	public String getUrlString();

	public boolean isFailed();

	public void setFailed(boolean failed);

	public boolean getFailed();

}
