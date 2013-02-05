package cn.crawlite4j.request;

public class IgnoreRequestException extends RuntimeException {

	private static final long serialVersionUID = -2212726810275389727L;

	public IgnoreRequestException() {
		super();
	}

	public IgnoreRequestException(String msg) {
		super(msg);
	}

	public IgnoreRequestException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
