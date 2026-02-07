package day3;

public class StringDemo6 {

	public static void main(String[] args) {
		/* 
		 實務應用
		 交易所股價報價資料如下:
		 時間 股票 現價 最低 最高 漲跌 成交量
		 2026/02/07 14:30,台積電,960.50,960.00,965.00,+2.35,1234567
         2026/02/07 14:31,聯發科,1248.50,1245.00,1252.00,-1.25,456789
         2026/02/07 14:32,鴻海,185.25,184.50,186.00,+0.82,3456789
		*/
		String marketData = """
				2026/02/07 14:30,台積電,960.50,960.00,965.00,+2.35,1234567
				2026/02/07 14:31,聯發科,1248.50,1245.00,1252.00,-1.25,456789
				2026/02/07 14:32,鴻海,185.25,184.50,186.00,+0.82,3456789
				""";
		
		System.out.println("台股行情分析器");
		System.out.println("==================================");
		System.out.println("時間 股票 現價 最低 最高 漲跌 成交量");
		System.out.println("----------------------------------");
		
		// 切筆數
		String[] lines = marketData.split("\n");
		for(int i=0;i<lines.length;i++) {
			String line = lines[i].trim();
			if(line.isEmpty()) {
				continue;
			}
			// 切欄位
			String[] fields = line.split(",");
			if(fields.length < 7) {
				continue;
			}
			String time   = fields[0]; // 時間
			String stock  = fields[1]; // 股票
			double price  = Double.parseDouble(fields[2]); // 現價(字串轉浮點數)
			double low    = Double.parseDouble(fields[3]); // 最低(字串轉浮點數) 
			double high   = Double.parseDouble(fields[4]); // 最高(字串轉浮點數)
			double change = Double.parseDouble(fields[5]); // 漲跌(字串轉浮點數)
			int    volume = Integer.parseInt(fields[6]);   // 成交量(字串轉整數)
			
			System.out.printf("%-12s %-6s $%5.1f$%5.1f$%5.1f$ %+.2f %,8d%n",
					time, stock, price, low, high, change, volume);
		}
		
	}

}
