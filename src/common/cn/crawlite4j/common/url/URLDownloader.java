package cn.crawlite4j.common.url;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import cn.crawlite4j.core.downloader.AbstractDownloader;
import cn.crawlite4j.core.request.IRequest;
import cn.crawlite4j.core.response.IResponse;

public class URLDownloader extends AbstractDownloader {

	private String defaultCharset = "utf-8";

	public void setDefaultCharset(String charset) {
		defaultCharset = charset;
	}

	public String getDefaultCharset() {
		return defaultCharset;
	}

	@Override
	public IResponse downloadRequest(IRequest request) {
		String urlString = request.getUrlString();
		URLResponse response = new URLResponse(urlString);
		try {
			URL url = new URL(urlString);
			URLConnection connection = url.openConnection();
			// get charset
			String charset = defaultCharset;
			try {
				String contentType = connection.getHeaderField("Content-Type");
				String[] contents = contentType.split(";");
				for (int i = 0; i < contents.length; i++) {
					String content = contents[i].trim();
					if (content.startsWith("charset=")) {
						charset = content.replaceFirst("charset=", "");
						break;
					}
				}
			} catch (Exception e) {
				charset = defaultCharset;
			}
			// set timeout
			connection.setConnectTimeout(request.getDownloadTimeout());
			// get content
			InputStream in = connection.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					in, charset));
			StringBuffer sb = new StringBuffer();
			String s = null;
			while ((s = reader.readLine()) != null) {
				sb.append(s).append("\n");
			}
			reader.close();
			response.setContent(sb.toString());
			response.setFailed(false);
			getLogger().debug("Open url " + request.getUrlString());
		} catch (Exception e) {
			getLogger().warn("Fail to open url " + request.getUrlString(), e);
		}
		return response;
	}

}
