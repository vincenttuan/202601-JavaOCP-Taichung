package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/mcdonald?useSSL=false&useUnicode=true&serverTimezone=Asia/Taipei";
	
	private static final String USERNAME = "root";
	
	private static final String PASSWORD = "12345678";
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	
	private DBUtil() {
		
	}
	
	public static Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		return conn;
	}
	
}
