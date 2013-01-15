package cn.crawlite4j.spider;

import java.util.UUID;

import cn.crawlite4j.downloader.IDownloader;
import cn.crawlite4j.log.ILogger;
import cn.crawlite4j.log.Level;
import cn.crawlite4j.log.SimpleConsoleLogger;
import cn.crawlite4j.parser.IParser;
import cn.crawlite4j.pipeline.IPipeline;

public abstract class AbstractSpider implements ISpider {
	
	public final static String spiderName = initSpiderName();
	
	protected final String uuid = initUuid();
	protected final ILogger logger = intiLogger();
	protected IDownloader defaultDownloader;
	protected IParser defaultParser;
	protected IPipeline defaultPipeline;
	
	//***********************************************************************//
	//Constructor                                                            //
	//***********************************************************************//
	
	protected AbstractSpider(IDownloader downloader, IParser parser, 
			IPipeline pipeline, Level logLevel) {
		if (logLevel != null) 
			logger.setLogLevel(logLevel);
		defaultDownloader = downloader;
		defaultParser = parser;
		defaultPipeline = pipeline;
	}
	
	//***********************************************************************//
	//abstract functions                                                     //
	//***********************************************************************//
	
	public abstract void addSeed(Object seed);
	
	public abstract void startRequests();
	
	//***********************************************************************//
	//implemented functions                                                  //
	//***********************************************************************//
	
	@Override
	public String getUuid() {
		return uuid;
	}
	
	@Override
	public ILogger getLogger() {
		return logger;
	}
	
	@Override
	public IDownloader getDefaultDownloader() {
		return defaultDownloader;
	}
	
	@Override
	public IParser getDefaultParser() {
		return defaultParser;
	}
	
	@Override
	public IPipeline getDefaultPipeline() {
		return defaultPipeline;
	}
	
	//***********************************************************************//
	//protected functions                                                                  //
	//***********************************************************************//
	
	protected String initUuid() {
		return UUID.randomUUID().toString();
	}
	
	protected ILogger intiLogger() {
		return new SimpleConsoleLogger();
	}
	
	protected static String initSpiderName() {
		return AbstractSpider.class.getName();
	}
	
}
