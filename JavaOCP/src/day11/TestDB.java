package day11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDB {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/demo";
		String user = "root";
		String password = "12345678";
		
		Connection conn = null;
		// 取得資料庫連線
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("連線成功 !");
			
			// ... do something
			
			
		} catch (SQLException e) {
			System.err.println("連線失敗 !");
			e.printStackTrace();
		} finally {
			if(conn != null) { // 關閉連線
				try {
					conn.close();
					System.out.println("關閉連線");
				} catch (SQLException e) {
					System.err.println("關閉失敗 !");
					e.printStackTrace();
				} 
			}
		}

	}

}
