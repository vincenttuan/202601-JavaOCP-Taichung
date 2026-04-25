package day11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

// 透過 try(xxx) 來自動進行連線關閉
// 語法名稱: try with resources 語法
public class TestDB2 {

	public static void main(String[] args) throws IOException {
		//String url = "jdbc:mysql://localhost:3306/demo";
		//String user = "root";
		//String password = "12345678";
		
		List<String> lines = Files.readAllLines(Paths.get("src/day11/conn.txt"));
		String url = lines.get(0);
		String user = lines.get(1);
		String password = lines.get(2);
		
		// 取得資料庫連線
		try(Connection conn = DriverManager.getConnection(url, user, password);) {
			System.out.println("連線成功 !");
			
			// ... do something
			
			
		} catch (SQLException e) {
			System.err.println("連線失敗 !");
			e.printStackTrace();
		}

	}

}
