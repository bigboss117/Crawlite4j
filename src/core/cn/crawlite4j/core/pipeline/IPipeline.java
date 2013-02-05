package cn.crawlite4j.core.pipeline;

import cn.crawlite4j.core.item.IItem;
import cn.crawlite4j.core.log.ILogger;

public interface IPipeline {

	public void setLogger(ILogger logger);

	public ILogger getLogger();

	public void processItem(IItem item);

}
