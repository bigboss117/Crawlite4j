package cn.crawlite4j.spider;

import java.util.LinkedList;
import java.util.List;

import cn.crawlite4j.downloader.IDownloader;
import cn.crawlite4j.downloader.SimpleDownloader;
import cn.crawlite4j.log.Level;
import cn.crawlite4j.parser.IParser;
import cn.crawlite4j.parser.SimpleParser;
import cn.crawlite4j.pipeline.IPipeline;
import cn.crawlite4j.pipeline.SimplePipeline;
import cn.crawlite4j.request.SimpleRequest;
import cn.crawlite4j.scheduler.IScheduler;
import cn.crawlite4j.scheduler.FIFOScheduler;

public class SimpleSpider extends AbstractSpider {

	protected List<Object> seeds = new LinkedList<Object>();

	protected SimpleSpider(IScheduler scheduler, IDownloader downloader,
			IParser parser, IPipeline pipeline, int threadNum, Level logLevel) {
		super(scheduler, downloader, parser, pipeline, threadNum, logLevel);
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
		ISpider spider = new SimpleSpider(new FIFOScheduler(),
				new SimpleDownloader(), new SimpleParser(),
				new SimplePipeline(), 1, Level.DEBUG);
		spider.addSeed("http://www.baidu.com");
		spider.addSeed("http://www.google.com");
		spider.addSeed("http://www.sina.com");
		spider.startRequests();

	}

}
