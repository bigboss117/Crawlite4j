package cn.crawlite4j.pipeline;

import cn.crawlite4j.item.IItem;

public class SimplePipeline extends AbstractPipeline {

	@Override
	public void processItem(IItem item) {
		getLogger().debug(item.toString());
	}

}
