package cn.crawlite4j.common.htmlunitdriver;

import java.util.concurrent.TimeUnit;

import cn.crawlite4j.core.request.AbstractRequest;

public class HtmlUnitDriverRequest extends AbstractRequest {

	protected boolean enableJavascript = false;
	protected int implicitlyWaitTimeout = 1000;
	protected final TimeUnit implicitlyWaitTimeUnit = TimeUnit.MILLISECONDS;
	protected int scriptTimeout = 1000;
	protected final TimeUnit scriptTimeUnit = TimeUnit.MILLISECONDS;
	
	public HtmlUnitDriverRequest(String url) {
		super(url);
	}
	
	public void setEnableJavascript(boolean enableJavascript) {
		this.enableJavascript = enableJavascript;
	}
	
	public boolean getEnableJavascript() {
		return enableJavascript;
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
	
}
