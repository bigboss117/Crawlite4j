package cn.crawlite4j.core.pipeline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class JdbcPipeline extends AbstractPipeline {
	
	protected Connection connection;
	
	public JdbcPipeline(String driverClassName, String url, String user, String password) {
		try {   
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {   
			throw new PipelineException(null, e);
		}
		getConnection(url, user, password);
	}
	
	protected void getConnection(String url, String user, String password) {
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new PipelineException(null, e);
		}
	}
	
	protected void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			throw new PipelineException(null, e);
		}
	}

}
