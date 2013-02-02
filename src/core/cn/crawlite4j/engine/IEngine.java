package cn.crawlite4j.engine;

import cn.crawlite4j.spider.ISpider;

public interface IEngine {

	public void setSpider(ISpider spider);

	public ISpider getSpider();

	public void start();

	public void stop();

}
