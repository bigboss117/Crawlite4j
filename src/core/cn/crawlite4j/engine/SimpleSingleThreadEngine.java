package cn.crawlite4j.engine;

import cn.crawlite4j.UnimplementFunctionException;
import cn.crawlite4j.spider.ISpider;

public class SimpleSingleThreadEngine extends AbstractEngine {

	// ***********************************************************************//
	// Constructor
	// ***********************************************************************//

	public SimpleSingleThreadEngine(int threadNum, ISpider spider) {
		super(threadNum, spider);
	}

	public SimpleSingleThreadEngine(ISpider spider) {
		super(spider);
	}

	// ***********************************************************************//
	// implemented functions
	// ***********************************************************************//

	@Override
	public void setThreadNum(int num) {
		throw new UnimplementFunctionException(
				"The engine can only use 1 thread.");
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

}
