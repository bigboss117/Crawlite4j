package cn.crawlite4j.common.url;

import cn.crawlite4j.response.AbstractResponse;

public class URLResponse extends AbstractResponse {

	private String content = null;

	public URLResponse(String url) {
		super(url);
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContet() {
		return content;
	}

}
