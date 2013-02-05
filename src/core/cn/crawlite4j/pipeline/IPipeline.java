package cn.crawlite4j.pipeline;

import cn.crawlite4j.item.IItem;
import cn.crawlite4j.log.ILogger;

public interface IPipeline {

	public void setLogger(ILogger logger);

	public ILogger getLogger();

	public void processItem(IItem item);

}
