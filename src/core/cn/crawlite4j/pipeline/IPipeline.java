package cn.crawlite4j.pipeline;

import java.util.List;

import cn.crawlite4j.item.IItem;
import cn.crawlite4j.spider.ISpider;

public interface IPipeline {

	public void setSpider(ISpider spider);

	public ISpider getSpider();

	public void processItem(List<IItem> itemList);

}
