package cn.crawlite4j.json;

public class JSONException extends Exception {

	private static final long serialVersionUID = -4877155915910654688L;
	private Throwable cause;

	public JSONException(String message) {
		super(message);
	}

	public JSONException(Throwable cause) {
		super(cause.getMessage());
		this.cause = cause;
	}

	public Throwable getCause() {
		return this.cause;
	}

}
