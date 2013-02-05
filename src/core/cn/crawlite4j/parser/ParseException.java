package cn.crawlite4j.parser;

public class ParseException extends RuntimeException {

	private static final long serialVersionUID = -133579925915724272L;

	public ParseException() {
		super();
	}

	public ParseException(String msg) {
		super(msg);
	}

	public ParseException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
