package cn.crawlite4j.engine;

public abstract class AbstractEngine implements IEngine {

	@Override
	public abstract void start();

	@Override
	public abstract void stop();

}
