package cn.crawlite4j.log;

public class Logger {
	
	private static Logger logger = null;
	private int level = Level.DEBUG;
	
	public Logger() {
		
	}
	
	public static synchronized Logger getLogger() {
		if (logger == null)
			logger = new Logger();
		return logger;
	}
	
	public void setLogLevel(int level) {
		this.level = level;
	}
	
	private synchronized void printLog(String level, String message) {
		System.out.println(level + " - " + message);
	}
	
	public void log(int level, String message) {
		switch (level) {
		case Level.FATAL :
			fatal(message);
			break;
		case Level.ERROR :
			error(message);
			break;
		case Level.WARN :
			warn(message);
			break;
		case Level.INFO :
			info(message);
			break;
		case Level.DEBUG :
			debug(message);
			break;
		case Level.TRACE :
			trace(message);
			break;
		case Level.ALL :
			all(message);
			break;
		default :
			break;
		}
	}
	
	public void fatal(String message) {
		if (Level.FATAL >= level)
			printLog("FATAL", message);
	}

	public void error(String message) {
		if (Level.ERROR >= level)
			printLog("ERROR", message);
	}
	
	public void warn(String message) {
		if (Level.WARN >= level)
			printLog("WARN", message);
	}
	
	public void info(String message) {
		if (Level.INFO >= level)
			printLog("INFO", message);
	}
	
	public void debug(String message) {
		if (Level.DEBUG >= level)
			printLog("DEBUG", message);
	}
	
	public void trace(String message) {
		if (Level.TRACE >= level)
			printLog("trace", message);
	}
	
	public void all(String message) {
		if (Level.ALL >= level)
			printLog("all", message);
	}
}
