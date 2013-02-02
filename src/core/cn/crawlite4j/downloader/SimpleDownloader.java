package cn.crawlite4j.downloader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import cn.crawlite4j.request.IRequest;
import cn.crawlite4j.response.IResponse;
import cn.crawlite4j.response.SimpleResponse;

public class SimpleDownloader extends AbstractDownloader {

	@Override
	public IResponse downloadRequest(IRequest request) {
		if (!(request instanceof IRequest))
			throw new IllegalArgumentException("request is not a IRequest");
		String urlString = request.getUrlString();
		SimpleResponse response = new SimpleResponse(urlString);
		try {
			URL url = new URL(urlString);
			URLConnection connection = url.openConnection();
			connection.setConnectTimeout(request.getDownloadTimeout());
			connection.setReadTimeout(request.getDownloadTimeout());
			InputStream in = connection.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					in, connection.getContentEncoding()));
			StringBuffer sb = new StringBuffer();
			String s = null;
			while ((s = reader.readLine()) != null) {
				sb.append(s);
			}
			reader.close();
			response.setContent(sb.toString());
			response.setSuccessful(true);
			getSpider().getLogger().debug("Open url " + request.getUrlString());
		} catch (Exception e) {
			getSpider().getLogger().warn(
					"Fail to open url" + request.getUrlString(), e);
		}
		return response;
	}

}
