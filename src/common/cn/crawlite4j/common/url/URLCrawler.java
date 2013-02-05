package cn.crawlite4j.common.url;

import java.util.LinkedList;
import java.util.List;

import cn.crawlite4j.core.crawler.AbstractCrawler;
import cn.crawlite4j.core.crawler.ICrawler;
import cn.crawlite4j.core.engine.SimpleMutilThreadEngine;
import cn.crawlite4j.core.log.Level;
import cn.crawlite4j.core.log.SimpleConsoleLogger;
import cn.crawlite4j.core.pipeline.LoggerPipeline;
import cn.crawlite4j.core.scheduler.FIFOScheduler;

public class URLCrawler extends AbstractCrawler {

	protected List<Object> seeds = new LinkedList<Object>();

	protected URLCrawler() {
		super();
	}

	@Override
	public void addSeed(Object seed) {
		seeds.add(seed);
		getLogger().info("Add seed : " + seed.toString());
	}

	@Override
	public void startRequests() {
		for (Object seed : seeds) {
			addRequest(new URLRequest((String) seed));
		}
	}

	public static void main(String[] args) {
		ICrawler spider = new URLCrawler();
		spider.setLogger(new SimpleConsoleLogger());
		spider.setLogLevel(Level.DEBUG);
		spider.setScheduler(new FIFOScheduler());
		spider.setDefaultDownloader(new URLDownloader());
		spider.setDefaultParser(new URLParser());
		spider.setDefaultPipeline(new LoggerPipeline());
		spider.setEngine(new SimpleMutilThreadEngine(1));

		spider.addSeed("http://www.baidu.com");
		spider.addSeed("http://www.google.com");
		spider.addSeed("http://www.sina.com");

		spider.runSpider();

	}

}
