package cn.crawlite4j.response;

public abstract class AbstractResponse implements IResponse {

	private final String urlString;
	private boolean successful;

	// Constructor
	public AbstractResponse(String url, boolean successful) {
		this.urlString = url;
		this.successful = successful;
	}

	public AbstractResponse(String url) {
		this(url, false);
	}

	// implemented
	@Override
	public String getUrlString() {
		return urlString;
	}

	@Override
	public boolean isSuccessful() {
		return successful;
	}

	@Override
	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}

	@Override
	public boolean getSuccessful() {
		return successful;
	}

}
