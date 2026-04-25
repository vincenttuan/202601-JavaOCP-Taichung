package day11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDB {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/demo";
		String user = "root";
		String password = "12345678";
		
		// 取得資料庫連線
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("連線成功 !");
			
		} catch (SQLException e) {
			System.err.println("連線失敗 !");
			e.printStackTrace();
		}

	}

}
