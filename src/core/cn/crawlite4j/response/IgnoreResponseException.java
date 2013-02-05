package cn.crawlite4j.response;

public class IgnoreResponseException extends RuntimeException {

	private static final long serialVersionUID = 5267439382830694108L;

	public IgnoreResponseException() {
		super();
	}

	public IgnoreResponseException(String msg) {
		super(msg);
	}

	public IgnoreResponseException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
