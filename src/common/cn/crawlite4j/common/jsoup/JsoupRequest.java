package cn.crawlite4j.common.jsoup;

import cn.crawlite4j.core.request.AbstractRequest;

public class JsoupRequest extends AbstractRequest {

	protected String userAgent = null;
	
	public JsoupRequest(String url) {
		super(url);
	}
	
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getUserAgent() {
		return userAgent;
	}

}
