package com.icss.hr.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		Connection conn = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:orcl", "scott",
				"tiger");
		return conn;
	}
	public static void close(ResultSet rs,Statement stat,Connection conn) throws SQLException{
		if(rs!=null)
			rs.close();
		if(stat!=null)
			stat.close();
		if(conn!=null)
			conn.close();
	}
}
