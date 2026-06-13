package util;

public class DBUtil {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/guestbookdb?useSSL=false&serverTimeZone=Asia/Taipei";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "12345678";
	
	static {
		
		try {
			Class.forName(""); // 動態載入 driver
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
