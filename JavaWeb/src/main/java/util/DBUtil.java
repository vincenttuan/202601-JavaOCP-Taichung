package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/guestbookdb?useSSL=false&serverTimeZone=Asia/Taipei";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "12345678";
	
	static {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 動態載入 driver
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection() throws Exception {
		return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
	}
	
}
