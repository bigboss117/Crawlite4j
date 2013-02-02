package cn.crawlite4j.pipeline;

import java.util.List;

import cn.crawlite4j.item.IItem;
import cn.crawlite4j.spider.ISpider;

public abstract class AbstractPipeline implements IPipeline {

	private ISpider spider;

	@Override
	public final void setSpider(ISpider spider) {
		this.spider = spider;
	}

	@Override
	public final ISpider getSpider() {
		return spider;
	}

	@Override
	public abstract void processItem(List<IItem> itemList);

}
