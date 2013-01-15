package cn.crawlite4j.log;

public interface ILogger {
	public void setLogLevel(Level level);
	public void log(String message, Level level);
	public void fatal(String message);
	public void error(String message);
	public void warn(String message);
	public void info(String message);
	public void debug(String message);
	public void trace(String message);
	public void log(Exception e, Level level);
	public void fatal(Exception e);
	public void error(Exception e);
	public void warn(Exception e);
	public void info(Exception e);
	public void debug(Exception e);
	public void trace(Exception e);
}
