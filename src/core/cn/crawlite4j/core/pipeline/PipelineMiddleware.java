package cn.crawlite4j.core.pipeline;

import cn.crawlite4j.core.item.IItem;

public class PipelineMiddleware extends AbstractPipelineMiddleware {

	@Override
	protected IItem processItem(IItem item) {
		if (item == null)
			throw new NullPointerException("item is null");
		return item;
	}

	@Override
	protected void processException(RuntimeException e) {
		throw e;
	}

}
