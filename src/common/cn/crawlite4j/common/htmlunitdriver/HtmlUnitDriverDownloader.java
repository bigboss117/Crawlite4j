package cn.crawlite4j.common.htmlunitdriver;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import cn.crawlite4j.core.downloader.AbstractDownloader;
import cn.crawlite4j.core.request.IRequest;
import cn.crawlite4j.core.response.IResponse;

public class HtmlUnitDriverDownloader extends AbstractDownloader {

	@Override
	public IResponse downloadRequest(IRequest request) {
		HtmlUnitDriverRequest htmlUnitDriverRequest = (HtmlUnitDriverRequest)request;
		HtmlUnitDriver driver = new HtmlUnitDriver();
		driver.setJavascriptEnabled(
			htmlUnitDriverRequest.getEnableJavascript());
		driver.manage().timeouts().implicitlyWait(
			htmlUnitDriverRequest.getImplicitlyWaitTimeout(), 
			htmlUnitDriverRequest.getImplicitlyWaitTimeUnit());
		driver.manage().timeouts().setScriptTimeout(
			htmlUnitDriverRequest.getScriptTimeout(), 
			htmlUnitDriverRequest.getScriptTimeUnit());
		String requestUrl = htmlUnitDriverRequest.getUrlString();
		String responseUrl = null;
		boolean failed = true;
		try {
			driver.get(requestUrl);
			responseUrl = driver.getCurrentUrl();
			failed = false;
			getLogger().info("Download page " + requestUrl);
		} catch (Exception e) {
			getLogger().warn("Cannot download page " + requestUrl, e);
			driver.quit();
		}
		HtmlUnitDriverResponse response = new HtmlUnitDriverResponse(responseUrl, failed, driver);
		return response;
	}

}
