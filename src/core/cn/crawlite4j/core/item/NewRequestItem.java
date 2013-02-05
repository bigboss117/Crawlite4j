package cn.crawlite4j.core.item;

import cn.crawlite4j.core.request.IRequest;

public class NewRequestItem implements IItem {

	private final IRequest request;
	
	public NewRequestItem(IRequest request) {
		this.request = request;
	}
	
	public IRequest getRequest() {
		return request;
	}
	
}
