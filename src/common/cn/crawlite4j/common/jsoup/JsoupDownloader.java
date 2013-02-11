package cn.crawlite4j.common.jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import cn.crawlite4j.core.downloader.AbstractDownloader;
import cn.crawlite4j.core.request.IRequest;
import cn.crawlite4j.core.response.IResponse;

public class JsoupDownloader extends AbstractDownloader {

	@Override
	public IResponse downloadRequest(IRequest request) {
		JsoupRequest jsoupRequest = (JsoupRequest)request;
		Document document = null;
		String requestUrl = jsoupRequest.getUrlString();
		String responseUrl = null;
		boolean failed = true;
		try {
			Connection connection = Jsoup.connect(requestUrl).timeout(jsoupRequest.getDownloadTimeout());
			String userAgent = jsoupRequest.getUserAgent();
			if (userAgent != null) {
				connection.userAgent(userAgent);
			}
			document = connection.get();
			responseUrl = document.baseUri();
			failed = false;
			getLogger().info("Download page " + requestUrl);
		} catch (Exception e) {
			getLogger().warn("Cannot download page " + requestUrl, e);
		}
		JsoupResponse jsoupResponse = new JsoupResponse(responseUrl, failed, document);
		return jsoupResponse;
	}

}
