package cn.crawlite4j.log;

public class SimpleConsoleLogger extends AbstractLogger {

	private String messageTemplate = "%s - %s";

	public SimpleConsoleLogger() {
		super();
	}

	@Override
	public synchronized void log(Object message, Level level) {
		log(message, null, level);
	}

	@Override
	public synchronized void log(Object message, Throwable t, Level level) {
		if (level.isGreaterOrEqualThan(logLevel)) {
			if (message != null) {
				System.out.println(String.format(messageTemplate,
						level.toString(), message.toString()));
			}
			if (t != null) {
				System.out.println(String.format(messageTemplate,
						level.toString(), t.toString()));
				for (StackTraceElement elemet : t.getStackTrace()) {
					System.out.println(String.format(messageTemplate,
							level.toString(), elemet.toString()));
				}
			}
		}
	}

}
