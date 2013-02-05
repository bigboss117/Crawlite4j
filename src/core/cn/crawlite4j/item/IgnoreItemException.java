package cn.crawlite4j.item;

public class IgnoreItemException extends RuntimeException {

	private static final long serialVersionUID = 2879847856140356823L;

	public IgnoreItemException() {
		super();
	}

	public IgnoreItemException(String msg) {
		super(msg);
	}

	public IgnoreItemException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}
