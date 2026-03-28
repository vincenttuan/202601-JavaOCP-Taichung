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
		String marketData = "" + 
				"2026/02/07 14:30,台積電,960.50,960.00,965.00,+2.35,1234567\n" +
				"2026/02/07 14:31,聯發科,1248.50,1245.00,1252.00,-1.25456789\n" +
				"2026/02/07 14:32,鴻　海,185.25,184.50,186.00,+0.82,3456789\n" +
				"2026/02/07 14:33,台達電,385.50,384.00,387.00,+1.45,876543\n" +
				"2026/02/07 14:34,日月光,165.75,164.50,166.25,+0.95,1234567\n" +
				"2026/02/07 14:35,中華電,128.50,128.00,129.00,+0.35,543210\n" +
				"2026/02/07 14:36,台　塑,82.75,82.25,83.25,-0.25,987654\n" +
				"2026/02/07 14:37,國泰金,52.80,52.50,53.00,+1.15,2109876\n" +
				"2026/02/07 14:38,富邦金,74.25,73.75,74.75,+0.65,1543210\n" +
				"2026/02/07 14:39,元大金,38.50,38.25,38.75,-0.85,654321\n" +
				"";
		
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
			
			System.out.printf("%-16s %-4s $%,7.1f $%6.1f $%6.1f $%+.2f %,10d%n",
					time, stock, price, low, high, change, volume);
		}
		
	}

}
