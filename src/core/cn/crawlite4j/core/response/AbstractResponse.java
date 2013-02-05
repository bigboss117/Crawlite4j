package cn.crawlite4j.core.response;

public abstract class AbstractResponse implements IResponse {

	private final String urlString;
	private boolean failed;

	// Constructor
	public AbstractResponse(String url, boolean failed) {
		this.urlString = url;
		this.failed = failed;
	}

	public AbstractResponse(String url) {
		this(url, true);
	}

	// implemented
	@Override
	public String getUrlString() {
		return urlString;
	}

	@Override
	public boolean isFailed() {
		return failed;
	}

	@Override
	public void setFailed(boolean failed) {
		this.failed = failed;
	}

	@Override
	public boolean getFailed() {
		return failed;
	}

}
