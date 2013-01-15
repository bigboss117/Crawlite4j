package cn.crawlite4j.log;

public class SimpleConsoleLogger extends AbstractLogger {
	
	private String messageTemplate = "%s - %s";
	
	public SimpleConsoleLogger() {
		super();
	}
	
	@Override
	public synchronized void log(String message, Level level) {
		if (level.isGreaterOrEqualThan(logLevel))
			System.out.println(String.format(messageTemplate, 
					level.toString(), message));
	}

	@Override
	public synchronized void log(Exception e, Level level) {
		if (level.isGreaterOrEqualThan(logLevel)) {
			System.out.println(String.format(messageTemplate, 
					level.toString(), e.toString()));
			for (StackTraceElement elemet : e.getStackTrace()) {
				System.out.println(String.format(messageTemplate, 
						level.toString(), elemet.toString()));
			}
		}
	}

}
