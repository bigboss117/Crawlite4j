package cn.crawlite4j.common.htmlunitdriver;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import cn.crawlite4j.core.response.AbstractResponse;

public class HtmlUnitDriverResponse extends AbstractResponse {

	protected HtmlUnitDriver driver = null;
	
	public HtmlUnitDriverResponse(String url, boolean failed, HtmlUnitDriver driver) {
		super(url, failed);
		this.driver = driver;
	}

	public HtmlUnitDriver getHtmlUnitDriver() {
		return driver;
	}
	
}
