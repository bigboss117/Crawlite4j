package cn.crawlite4j.core.pipeline;

import cn.crawlite4j.core.item.IItem;

public abstract class AbstractPipelineMiddleware implements IPipelineMiddleware {

	@Override
	public void pipe(IPipeline pipeline, IItem item) {
		try {
			item = processItem(item);
			pipeline.processItem(item);
		} catch (RuntimeException e) {
			processException(e);
		}
	}

	protected abstract IItem processItem(IItem item);

	protected abstract void processException(RuntimeException e);

}
