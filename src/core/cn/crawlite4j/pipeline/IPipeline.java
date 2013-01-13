package cn.crawlite4j.pipeline;

import cn.crawlite4j.item.IItem;
import cn.crawlite4j.spider.ISpider;

public interface IPipeline {
	public void processItem(IItem item, ISpider spider);
}
