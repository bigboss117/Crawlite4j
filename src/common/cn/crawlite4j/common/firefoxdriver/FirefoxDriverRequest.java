package cn.crawlite4j.common.firefoxdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxProfile;

import cn.crawlite4j.core.request.AbstractRequest;

public class FirefoxDriverRequest extends AbstractRequest {
	
	protected int implicitlyWaitTimeout = 1000;
	protected final TimeUnit implicitlyWaitTimeUnit = TimeUnit.MILLISECONDS;
	protected int scriptTimeout = 1000;
	protected final TimeUnit scriptTimeUnit = TimeUnit.MILLISECONDS;
	protected FirefoxProfile profile = null;
	
	public FirefoxDriverRequest(String url) {
		super(url);
	}
	
	public void setImplicitlyWaitTimeout(int timeout) {
		implicitlyWaitTimeout = timeout;
	}
	
	public int getImplicitlyWaitTimeout() {
		return implicitlyWaitTimeout;
	}
	
	public TimeUnit getImplicitlyWaitTimeUnit() {
		return implicitlyWaitTimeUnit;
	}
	
	public void setScriptTimeout(int timeout) {
		scriptTimeout = timeout;
	}
	
	public int getScriptTimeout() {
		return scriptTimeout;
	}
	
	public TimeUnit getScriptTimeUnit() {
		return scriptTimeUnit;
	}
	
	public void setProfile(FirefoxProfile profile) {
		this.profile = profile;
	}
	
	public FirefoxProfile getProfile() {
		return profile;
	}

}
