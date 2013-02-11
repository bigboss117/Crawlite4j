package cn.crawlite4j.common.jsoup;

import org.jsoup.nodes.Document;

import cn.crawlite4j.core.response.AbstractResponse;

public class JsoupResponse extends AbstractResponse {
	
	protected Document document = null;
	
	public JsoupResponse(String url, boolean failed, Document document) {
		super(url, failed);
		this.document = document;
	}
	
	public Document getDocument() {
		return document;
	}

}
