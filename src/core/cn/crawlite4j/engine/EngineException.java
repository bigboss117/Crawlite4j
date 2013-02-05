package cn.crawlite4j.engine;

public class EngineException extends RuntimeException {

	private static final long serialVersionUID = -3073586186605215401L;

	public EngineException() {
		super();
	}

	public EngineException(String msg) {
		super(msg);
	}

	public EngineException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}
