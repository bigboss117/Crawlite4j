package cn.crawlite4j.pipeline;

import cn.crawlite4j.item.IItem;
import cn.crawlite4j.spider.ISpider;

public abstract class AbstractPipeline implements IPipeline {

	public abstract void processItem(IItem item, ISpider spider);

}
