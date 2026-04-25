package day11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Exception7 {
	public static void main(String[] args) {
		// 讀取檔案內容
		Path path = Paths.get("src/day11/score.txt");
		System.out.println(path);
		// 此路徑是否存在 ?
		if(Files.exists(path)) {
			System.out.println("此路徑檔案存在");
		} else {
			System.err.println("此路徑檔案不存在");
			return;
		}
		// 讀取檔案內容 1
		System.out.println("讀取檔案內容:");
		try {
			String content = Files.readString(path);
			System.out.println(content);
		} catch (IOException e) {
			System.out.println("讀取時發生錯誤");
			e.printStackTrace(); // 印出詳細錯誤
		}
		
		// 讀取檔案內容 2
		Stream<String> lines = null;
		try {
			lines = Files.lines(path);
			lines.forEach(line -> {
				System.out.println(line);
			});
		} catch (IOException e) {
			System.out.println("讀取時發生錯誤");
			e.printStackTrace(); // 印出詳細錯誤
		} finally {
			if(lines != null) {
				lines.close();
			}
		}
		
	}
}
