package cn.crawlite4j.core.pipeline;

import cn.crawlite4j.core.item.IItem;

public class LogHashCodePipeline extends AbstractPipeline {

	@Override
	public void processItem(IItem item) {
		getLogger().debug("Item hashCode : " + item.hashCode());
	}

}
