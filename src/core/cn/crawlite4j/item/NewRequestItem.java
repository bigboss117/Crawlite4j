package cn.crawlite4j.item;

import cn.crawlite4j.request.IRequest;

public class NewRequestItem implements IItem {

	private final IRequest request;
	
	public NewRequestItem(IRequest request) {
		this.request = request;
	}
	
	public IRequest getRequest() {
		return request;
	}
	
}
