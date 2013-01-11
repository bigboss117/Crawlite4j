package cn.crawlite4j.engine;

public interface IEngine {

	public void setThreadNum(int num);

	public int getThreadNum();

	public void start();

	public void stop();

}
