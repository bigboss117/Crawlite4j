package cn.crawlite4j.core.pipeline;

import cn.crawlite4j.core.item.IItem;
import cn.crawlite4j.core.log.ILogger;

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
