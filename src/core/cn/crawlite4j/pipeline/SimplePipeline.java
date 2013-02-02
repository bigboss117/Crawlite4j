package cn.crawlite4j.pipeline;

import java.util.List;

import cn.crawlite4j.item.IItem;

public class SimplePipeline extends AbstractPipeline {

	@Override
	public void processItem(List<IItem> itemList) {
		for (IItem item : itemList) {
			this.getSpider().getLogger().debug(item.toString());
		}
	}

}
