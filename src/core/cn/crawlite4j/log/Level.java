package cn.crawlite4j.log;

import java.util.HashMap;

public class Level {
	
	int levelInt;
	String levelString;
	
	protected final static int OFF_INT = Integer.MAX_VALUE;
	protected final static int FATAL_INT = 60000;
	protected final static int ERROR_INT = 50000;
	protected final static int WARN_INT  = 40000;
	protected final static int INFO_INT  = 30000;
	protected final static int DEBUG_INT = 20000;
	protected final static int TRACE_INT = 10000;
	protected final static int ALL_INT = Integer.MIN_VALUE;
	
	public final static Level OFF = new Level(OFF_INT, "OFF");
	public final static Level FATAL = new Level(FATAL_INT, "FATAL");
	public final static Level ERROR = new Level(ERROR_INT, "ERROR");
	public final static Level WARN = new Level(WARN_INT, "WARN");
	public final static Level INFO = new Level(INFO_INT, "INFO");
	public final static Level DEBUG = new Level(DEBUG_INT, "DEBUG");
	public final static Level TRACE = new Level(TRACE_INT, "TRACE");
	public final static Level ALL = new Level(ALL_INT, "ALL");
	
	protected final static HashMap<String, Level> stringLevelMap = initStringLevelMap();
	protected final static HashMap<Integer, Level> integerLevelMap = initIntegerLevelMap();
	
	protected Level(int levelInt, String levelString) {
		this.levelInt = levelInt;
		this.levelString = levelString;
	}
	
	protected static HashMap<String, Level> initStringLevelMap() {
		HashMap<String, Level> map = new HashMap<String, Level>();
		map.put(Level.ALL.levelString, Level.ALL);
		map.put(Level.TRACE.levelString, Level.TRACE);
		map.put(Level.DEBUG.levelString, Level.DEBUG);
		map.put(Level.INFO.levelString, Level.INFO);
		map.put(Level.WARN.levelString, Level.WARN);
		map.put(Level.ERROR.levelString, Level.ERROR);
		map.put(Level.FATAL.levelString, Level.FATAL);
		map.put(Level.OFF.levelString, Level.OFF);
		return map;
	}
	
	protected static HashMap<Integer, Level> initIntegerLevelMap() {
		HashMap<Integer, Level> map = new HashMap<Integer, Level>();
		map.put(Level.ALL.levelInt, Level.ALL);
		map.put(Level.TRACE.levelInt, Level.TRACE);
		map.put(Level.DEBUG.levelInt, Level.DEBUG);
		map.put(Level.INFO.levelInt, Level.INFO);
		map.put(Level.WARN.levelInt, Level.WARN);
		map.put(Level.ERROR.levelInt, Level.ERROR);
		map.put(Level.FATAL.levelInt, Level.FATAL);
		map.put(Level.OFF.levelInt, Level.OFF);
		return map;
	}
	
	public static Level toLevel(String levelString) {
		return toLevel(levelString, Level.DEBUG);
	}
	
	public static Level toLevel(int levelInt) {
		return toLevel(levelInt, Level.DEBUG);
	}
	
	public static Level toLevel(String levelString, Level defaultLevel) {
		if (stringLevelMap.containsKey(levelString))
			return stringLevelMap.get(levelString);
		return defaultLevel;
	}
	
	public static Level toLevel(int levelInt, Level defaultLevel) {
		if (integerLevelMap.containsKey(levelInt))
			return integerLevelMap.get(levelInt);
		return defaultLevel;
	}
	
	public boolean isGreaterOrEqualThan(Level level) {
		return levelInt >= level.levelInt;
	}
	
	@Override
	public final String toString() {
		return levelString;
	}
	
	public final int toInt() {
		return levelInt;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Level) {
			Level level = (Level)o;
			return (this.levelInt == level.levelInt);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
}
