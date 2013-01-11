package cn.crawlite4j.engine;

import cn.crawlite4j.spider.ISpider;

public abstract class AbstractEngine implements IEngine {

	protected final ISpider spider;
	protected int threadNum = 1;

	// ***********************************************************************//
	// Constructor
	// ***********************************************************************//

	public AbstractEngine(int threadNum, ISpider spider) {
		this.spider = spider;
		setThreadNum(threadNum);
	}

	public AbstractEngine(ISpider spider) {
		this(1, spider);
	}

	// ***********************************************************************//
	// abstract functions
	// ***********************************************************************//

	@Override
	public abstract void start();

	@Override
	public abstract void stop();

	// ***********************************************************************//
	// implemented functions
	// ***********************************************************************//

	@Override
	public void setThreadNum(int num) {
		threadNum = num;
	}

	@Override
	public int getThreadNum() {
		return threadNum;
	}

}
