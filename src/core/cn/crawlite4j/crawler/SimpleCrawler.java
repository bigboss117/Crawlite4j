package cn.crawlite4j.crawler;

import java.util.LinkedList;
import java.util.List;

import cn.crawlite4j.downloader.URLDownloader;
import cn.crawlite4j.engine.SimpleMutilThreadEngine;
import cn.crawlite4j.log.Level;
import cn.crawlite4j.log.SimpleConsoleLogger;
import cn.crawlite4j.parser.SimpleParser;
import cn.crawlite4j.pipeline.SimplePipeline;
import cn.crawlite4j.request.SimpleRequest;
import cn.crawlite4j.scheduler.FIFOScheduler;

public class SimpleCrawler extends AbstractCrawler {

	protected List<Object> seeds = new LinkedList<Object>();

	protected SimpleCrawler() {
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
			addRequest(new SimpleRequest((String) seed));
		}
	}

	public static void main(String[] args) {
		ICrawler spider = new SimpleCrawler();
		spider.setLogger(new SimpleConsoleLogger());
		spider.setLogLevel(Level.DEBUG);
		spider.setScheduler(new FIFOScheduler());
		spider.setDefaultDownloader(new URLDownloader());
		spider.setDefaultParser(new SimpleParser());
		spider.setDefaultPipeline(new SimplePipeline());
		spider.setEngine(new SimpleMutilThreadEngine(1));

		spider.addSeed("http://www.baidu.com");
		spider.addSeed("http://www.google.com");
		spider.addSeed("http://www.sina.com");

		spider.runSpider();

	}

}
