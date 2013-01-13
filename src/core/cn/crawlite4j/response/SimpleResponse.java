package cn.crawlite4j.response;

public class SimpleResponse extends AbstractResponse {
	
	private String content = null;
	
	public SimpleResponse(String url) {
		super(url);
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getContet() {
		return content;
	}

}
