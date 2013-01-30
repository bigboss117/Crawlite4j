package cn.crawlite4j.log;

public abstract class AbstractLogger implements ILogger {

	protected Level logLevel;

	// ***********************************************************************//
	// Constructor
	// ***********************************************************************//

	protected AbstractLogger(Level level) {
		setLevel(level);
	}

	protected AbstractLogger() {
		this(Level.DEBUG);
	}

	// ***********************************************************************//
	// abstract functions
	// ***********************************************************************//

	@Override
	public abstract void log(Object message, Level level);

	@Override
	public abstract void log(Object message, Throwable t, Level level);

	// ***********************************************************************//
	// implemented functions
	// ***********************************************************************//

	@Override
	public void setLevel(Level level) {
		logLevel = level;
	}

	@Override
	public Level getLevel() {
		return logLevel;
	}

	@Override
	public void fatal(Object message) {
		log(message, Level.FATAL);
	}

	@Override
	public void error(Object message) {
		log(message, Level.ERROR);
	}

	@Override
	public void warn(Object message) {
		log(message, Level.WARN);
	}

	@Override
	public void info(Object message) {
		log(message, Level.INFO);
	}

	@Override
	public void debug(Object message) {
		log(message, Level.DEBUG);
	}

	@Override
	public void trace(Object message) {
		log(message, Level.TRACE);
	}

	@Override
	public void fatal(Object message, Throwable t) {
		log(message, t, Level.FATAL);
	}

	@Override
	public void error(Object message, Throwable t) {
		log(message, t, Level.ERROR);
	}

	@Override
	public void warn(Object message, Throwable t) {
		log(message, t, Level.WARN);
	}

	@Override
	public void info(Object message, Throwable t) {
		log(message, t, Level.INFO);
	}

	@Override
	public void debug(Object message, Throwable t) {
		log(message, t, Level.DEBUG);
	}

	@Override
	public void trace(Object message, Throwable t) {
		log(message, t, Level.TRACE);
	}

	// ***********************************************************************//
	// public functions
	// ***********************************************************************//

}
