package cn.crawlite4j.pipeline;

import cn.crawlite4j.item.IItem;

public interface IPipelineMiddleware {
	
	public void pipe(IPipeline pipeline, IItem item);

}
