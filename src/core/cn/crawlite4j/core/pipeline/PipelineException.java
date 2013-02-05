package cn.crawlite4j.core.pipeline;

public class PipelineException extends RuntimeException {

	private static final long serialVersionUID = 8554146528110355168L;

	public PipelineException() {
		super();
	}

	public PipelineException(String msg) {
		super(msg);
	}

	public PipelineException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}
