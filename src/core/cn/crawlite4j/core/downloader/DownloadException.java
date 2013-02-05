package cn.crawlite4j.core.downloader;

public class DownloadException extends RuntimeException {

	private static final long serialVersionUID = 8395104066426319940L;

	public DownloadException() {
		super();
	}

	public DownloadException(String msg) {
		super(msg);
	}

	public DownloadException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
