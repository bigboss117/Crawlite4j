package cn.crawlite4j.common.firefoxdriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import cn.crawlite4j.core.downloader.AbstractDownloader;
import cn.crawlite4j.core.request.IRequest;
import cn.crawlite4j.core.response.IResponse;

public class FirefoxDriverDownloader extends AbstractDownloader {

	@Override
	public IResponse downloadRequest(IRequest request) {
		FirefoxDriverRequest firefoxDriverRequest = (FirefoxDriverRequest)request;
		FirefoxDriver driver = null;
		FirefoxProfile profile = firefoxDriverRequest.getProfile();
		if (profile != null) {
			driver = new FirefoxDriver(profile);
		} else {
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().pageLoadTimeout(
				firefoxDriverRequest.getDownloadTimeout(), 
				firefoxDriverRequest.getDownloadTimeUnit());
		driver.manage().timeouts().implicitlyWait(
				firefoxDriverRequest.getImplicitlyWaitTimeout(), 
				firefoxDriverRequest.getImplicitlyWaitTimeUnit());
		driver.manage().timeouts().setScriptTimeout(
				firefoxDriverRequest.getScriptTimeout(), 
				firefoxDriverRequest.getScriptTimeUnit());
		String requestUrl = firefoxDriverRequest.getUrlString();
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
		FirefoxDriverResponse response = new FirefoxDriverResponse(responseUrl, failed, driver);
		return response;
	}

}
