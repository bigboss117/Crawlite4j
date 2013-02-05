package cn.crawlite4j.pipeline;

import cn.crawlite4j.item.IItem;
import cn.crawlite4j.log.ILogger;

public abstract class AbstractPipeline implements IPipeline {

	private ILogger logger;

	@Override
	public final void setLogger(ILogger logger) {
		this.logger = logger;
	}

	@Override
	public final ILogger getLogger() {
		return logger;
	}

	@Override
	public abstract void processItem(IItem item);

}
