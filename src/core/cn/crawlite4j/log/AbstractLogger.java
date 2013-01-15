package cn.crawlite4j.log;

public abstract class AbstractLogger implements ILogger {

	protected Level logLevel;
	
	//***********************************************************************//
	//Constructor                                                            //
	//***********************************************************************//
	
	protected AbstractLogger(Level level) {
		this.logLevel = level;
	}
	
	protected AbstractLogger() {
		this(Level.DEBUG);
	}

	//***********************************************************************//
	//abstract functions                                                     //
	//***********************************************************************//
	
	@Override
	public abstract void log(String message, Level level);
	
	@Override
	public abstract void log(Exception e, Level level);
	
	//***********************************************************************//
	//implemented functions                                                  //
	//***********************************************************************//
	
	@Override
	public void setLogLevel(Level level) {
		this.logLevel = level;
	}
	
	@Override
	public void fatal(String message) {
		log(message, Level.FATAL);
	}

	@Override
	public void error(String message) {
		log(message, Level.ERROR);
	}
	
	@Override
	public void warn(String message) {
		log(message, Level.WARN);
	}
	
	@Override
	public void info(String message) {
		log(message, Level.INFO);
	}
	
	@Override
	public void debug(String message) {
		log(message, Level.DEBUG);
	}
	
	@Override
	public void trace(String message) {
		log(message, Level.TRACE);
	}
	
	@Override
	public void fatal(Exception e) {
		log(e, Level.FATAL);
	}

	@Override
	public void error(Exception e) {
		log(e, Level.ERROR);
	}

	@Override
	public void warn(Exception e) {
		log(e, Level.WARN);
	}

	@Override
	public void info(Exception e) {
		log(e, Level.INFO);
	}

	@Override
	public void debug(Exception e) {
		log(e, Level.DEBUG);
	}

	@Override
	public void trace(Exception e) {
		log(e, Level.TRACE);
	}
	
	//***********************************************************************//
	//public functions                                                       //
	//***********************************************************************//
	
	public Level getLogLevel() {
		return logLevel;
	}
	
}
