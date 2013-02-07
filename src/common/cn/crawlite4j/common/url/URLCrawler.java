package cn.crawlite4j.common.url;

import java.util.LinkedList;
import java.util.List;

import cn.crawlite4j.core.crawler.AbstractCrawler;
import cn.crawlite4j.core.crawler.ICrawler;
import cn.crawlite4j.core.engine.MutilThreadEngine;
import cn.crawlite4j.core.log.Level;
import cn.crawlite4j.core.log.SimpleConsoleLogger;
import cn.crawlite4j.core.pipeline.LogHashCodePipeline;
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
		ICrawler crawler = new URLCrawler();
		crawler.setLogger(new SimpleConsoleLogger());
		crawler.setLogLevel(Level.DEBUG);
		crawler.setScheduler(new FIFOScheduler());
		crawler.setDefaultDownloader(new URLDownloader());
		crawler.setDefaultParser(new URLParser());
		crawler.setDefaultPipeline(new LogHashCodePipeline());
		crawler.setEngine(new MutilThreadEngine(5));

		crawler.addSeed("http://www.baidu.com");
		crawler.addSeed("http://www.google.com");
		crawler.addSeed("http://www.sina.com");

		crawler.runCrawler();

		synchronized (crawler) {
			try {
				crawler.wait(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		crawler.stopCrawler();

	}

}
