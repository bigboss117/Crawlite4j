package cn.crawlite4j.core.pipeline;

public abstract class MysqlPipeline extends JdbcPipeline {

	public MysqlPipeline(String url, String user, String password) {
		super("com.mysql.jdbc.Driver", url, user, password);
	}

}
