package cn.crawlite4j.common.firefoxdriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import cn.crawlite4j.core.response.AbstractResponse;

public class FirefoxDriverResponse extends AbstractResponse {

	protected FirefoxDriver driver = null;
	
	public FirefoxDriverResponse(String url, boolean failed, FirefoxDriver driver) {
		super(url, failed);
		this.driver = driver;
	}
	
	public FirefoxDriver getFirefoxDriver() {
		return driver;
	}
	
}
