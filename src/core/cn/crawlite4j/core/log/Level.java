package cn.crawlite4j.core.log;

import java.util.HashMap;

public class Level {

	protected int levelInt;
	protected String levelString;

	public final static int OFF_INT = Integer.MAX_VALUE;
	public final static int FATAL_INT = 60000;
	public final static int ERROR_INT = 50000;
	public final static int WARN_INT = 40000;
	public final static int INFO_INT = 30000;
	public final static int DEBUG_INT = 20000;
	public final static int TRACE_INT = 10000;
	public final static int ALL_INT = Integer.MIN_VALUE;

	public final static String OFF_STR = "OFF";
	public final static String FATAL_STR = "FATAL";
	public final static String ERROR_STR = "ERROR";
	public final static String WARN_STR = "WARN";
	public final static String INFO_STR = "INFO";
	public final static String DEBUG_STR = "DEBUG";
	public final static String TRACE_STR = "TRACE";
	public final static String ALL_STR = "ALL";

	public final static Level OFF = new Level(OFF_INT, OFF_STR);
	public final static Level FATAL = new Level(FATAL_INT, FATAL_STR);
	public final static Level ERROR = new Level(ERROR_INT, ERROR_STR);
	public final static Level WARN = new Level(WARN_INT, WARN_STR);
	public final static Level INFO = new Level(INFO_INT, INFO_STR);
	public final static Level DEBUG = new Level(DEBUG_INT, DEBUG_STR);
	public final static Level TRACE = new Level(TRACE_INT, TRACE_STR);
	public final static Level ALL = new Level(ALL_INT, ALL_STR);

	protected final static HashMap<String, Level> stringLevelMap = initStringLevelMap();
	protected final static HashMap<Integer, Level> integerLevelMap = initIntegerLevelMap();

	protected Level(int levelInt, String levelString) {
		this.levelInt = levelInt;
		this.levelString = levelString;
	}

	protected static HashMap<String, Level> initStringLevelMap() {
		HashMap<String, Level> map = new HashMap<String, Level>();
		map.put(ALL_STR, ALL);
		map.put(TRACE_STR, TRACE);
		map.put(DEBUG_STR, DEBUG);
		map.put(INFO_STR, INFO);
		map.put(WARN_STR, WARN);
		map.put(ERROR_STR, ERROR);
		map.put(FATAL_STR, FATAL);
		map.put(OFF_STR, OFF);
		return map;
	}

	protected static HashMap<Integer, Level> initIntegerLevelMap() {
		HashMap<Integer, Level> map = new HashMap<Integer, Level>();
		map.put(ALL_INT, ALL);
		map.put(TRACE_INT, TRACE);
		map.put(DEBUG_INT, DEBUG);
		map.put(INFO_INT, INFO);
		map.put(WARN_INT, WARN);
		map.put(ERROR_INT, ERROR);
		map.put(FATAL_INT, FATAL);
		map.put(OFF_INT, OFF);
		return map;
	}

	public static Level toLevel(String levelString) {
		return toLevel(levelString, DEBUG);
	}

	public static Level toLevel(int levelInt) {
		return toLevel(levelInt, DEBUG);
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
			Level level = (Level) o;
			return (this.levelInt == level.levelInt);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

}
