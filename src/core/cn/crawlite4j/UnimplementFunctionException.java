package cn.crawlite4j;

public class UnimplementFunctionException extends RuntimeException {

	private static final long serialVersionUID = -3396156126819628473L;

	public UnimplementFunctionException() {
		super();
	}

	public UnimplementFunctionException(String msg) {
		super(msg);
	}

	public UnimplementFunctionException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
