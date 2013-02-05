package cn.crawlite4j.common.url;

import cn.crawlite4j.item.AbstractItem;

public class URLItem extends AbstractItem {

	private String content;

	public URLItem(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return content;
	}

}
