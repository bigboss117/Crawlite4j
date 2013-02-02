package cn.crawlite4j.spider;

import java.util.LinkedList;
import java.util.List;

import cn.crawlite4j.downloader.SimpleDownloader;
import cn.crawlite4j.engine.SimpleMutilThreadEngine;
import cn.crawlite4j.log.Level;
import cn.crawlite4j.log.SimpleConsoleLogger;
import cn.crawlite4j.parser.SimpleParser;
import cn.crawlite4j.pipeline.SimplePipeline;
import cn.crawlite4j.request.SimpleRequest;
import cn.crawlite4j.scheduler.FIFOScheduler;

public class SimpleSpider extends AbstractSpider {

	protected List<Object> seeds = new LinkedList<Object>();

	protected SimpleSpider() {
		super();
	}

	@Override
	public void addSeed(Object seed) {
		seeds.add(seed);
		logger.info("Add seed : " + seed.toString());
	}

	@Override
	public void startRequests() {
		for (Object seed : seeds) {
			addRequest(new SimpleRequest((String) seed));
		}
	}

	public static void main(String[] args) {
		ISpider spider = new SimpleSpider();
		spider.setLogger(new SimpleConsoleLogger());
		spider.setLogLevel(Level.DEBUG);
		spider.setScheduler(new FIFOScheduler());
		spider.setDefaultDownloader(new SimpleDownloader());
		spider.setDefaultParser(new SimpleParser());
		spider.setDefaultPipeline(new SimplePipeline());
		spider.setEngine(new SimpleMutilThreadEngine(1));

		spider.addSeed("http://www.baidu.com");
		spider.addSeed("http://www.google.com");
		spider.addSeed("http://www.sina.com");

		spider.runSpider();

	}

}
