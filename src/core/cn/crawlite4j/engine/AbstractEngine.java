package cn.crawlite4j.engine;

import cn.crawlite4j.spider.ISpider;

public abstract class AbstractEngine implements IEngine {

	private ISpider spider;

	// ***********************************************************************//
	// Constructor
	// ***********************************************************************//

	public AbstractEngine() {

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
	public final void setSpider(ISpider spider) {
		this.spider = spider;
	}

	@Override
	public final ISpider getSpider() {
		return spider;
	}

}
