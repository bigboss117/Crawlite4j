package cn.crawlite4j.core.scheduler;

public class ScheduleException extends RuntimeException {

	private static final long serialVersionUID = 3650330320815769192L;

	public ScheduleException() {
		super();
	}

	public ScheduleException(String msg) {
		super(msg);
	}

	public ScheduleException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
