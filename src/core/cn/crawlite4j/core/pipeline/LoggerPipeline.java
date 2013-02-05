package cn.crawlite4j.core.pipeline;

import cn.crawlite4j.core.item.IItem;

public class LoggerPipeline extends AbstractPipeline {

	@Override
	public void processItem(IItem item) {
		getLogger().debug(item.toString());
	}

}
