package cn.crawlite4j.item;

public class SimpleItem extends AbstractItem {

	private String content;

	public SimpleItem(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return content;
	}

}
