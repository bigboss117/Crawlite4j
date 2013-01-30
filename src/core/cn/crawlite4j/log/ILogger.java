package cn.crawlite4j.log;

public interface ILogger {

	public Level getLevel();

	public void setLevel(Level level);

	public void log(Object message, Level level);

	public void log(Object message, Throwable t, Level level);

	public void fatal(Object message);

	public void fatal(Object message, Throwable t);

	public void error(Object message);

	public void error(Object message, Throwable t);

	public void warn(Object message);

	public void warn(Object message, Throwable t);

	public void info(Object message);

	public void info(Object message, Throwable t);

	public void debug(Object message);

	public void debug(Object message, Throwable t);

	public void trace(Object message);

	public void trace(Object message, Throwable t);

}
