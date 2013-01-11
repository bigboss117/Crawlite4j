package cn.crawlite4j.engine;

import java.util.ArrayList;
import java.util.List;

import cn.crawlite4j.spider.ISpider;

public class SimpleMutilThreadEngine extends AbstractEngine {

	protected List<Thread> threads;

	// ***********************************************************************//
	// Constructor
	// ***********************************************************************//

	public SimpleMutilThreadEngine(int threadNum, ISpider spider) {
		super(threadNum, spider);
		initThreads();
	}

	public SimpleMutilThreadEngine(ISpider spider) {
		super(spider);
		initThreads();
	}

	// ***********************************************************************//
	// implemented functions
	// ***********************************************************************//

	@Override
	public void start() {
		for (Thread thread : threads) {
			thread.start();
		}
	}

	@Override
	public void stop() {

	}

	// ***********************************************************************//
	// protected functions
	// ***********************************************************************//

	protected void initThreads() {
		threads = new ArrayList<Thread>(threadNum);
		for (int i = 0; i < threadNum; i++) {
			threads.add(new Thread(new EngineThread(this)));
		}
	}

	// ***********************************************************************//
	// internal class
	// ***********************************************************************//

	protected class EngineThread implements Runnable {

		private final ISpider spider;
		private final SimpleMutilThreadEngine engine;

		public EngineThread(SimpleMutilThreadEngine engine) {
			this.engine = engine;
			this.spider = engine.spider;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub

		}

	}

}
