package cn.crawlite4j.core.pipeline;

import cn.crawlite4j.core.item.IItem;

public interface IPipelineMiddleware {
	
	public void pipe(IPipeline pipeline, IItem item);

}
