package pha.com.common.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class getConnection {
	public static Connection getConn(){
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
		BasicDataSource basicDataSource = (BasicDataSource)wac.getBean("dataSource");
		try {
			return basicDataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
