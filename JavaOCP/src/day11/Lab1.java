package day11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * 讀取 score.txt
 * 過濾 不是數字, 不在 0~100 間的資料
 * 計算 有效筆數, 總分, 平均
 * 結果寫入 result.txt
 * */
public class Lab1 {
	
	public static void main(String[] args) {
		Path inputPath = Paths.get("src/day11/score.txt"); // 讀取路徑
		Path outputPath = Paths.get("src/day11/result.txt"); // 寫入路徑
		
		try {
			// 讀檔
			List<String> lines = Files.readAllLines(inputPath);
			
			int sum = 0; // 總和
			int count = 0; // 有效資料
			// 走訪 + 過濾資料
			for(String line : lines) {
				try {
					// 數字轉換檢查
					int score = Integer.parseInt(line);
					// 數字範圍檢查
					if(score < 0 || score > 100) {
						System.err.println(score + " 範圍錯誤");
						continue;
					}
					count++; // 有效資料 + 1
					sum += score; // 計算總和
					System.out.println(score);
				} catch (NumberFormatException e) {
					System.err.println(line + " 無法轉成 int");
				}
			}
			
			double avg = sum / count;
			System.out.println("有效:" + count);
			System.out.println("總分:" + sum);
			System.out.println("平均:" + avg);
			
			// 寫檔
			// 組合結果文字
			StringBuilder sb = new StringBuilder();
			sb.append("有效:").append(count).append("\n");
			sb.append("總分:").append(sum).append("\n");
			sb.append("平均:").append(avg).append("\n");
			
			// 寫檔完成
			Files.writeString(outputPath, sb.toString());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
