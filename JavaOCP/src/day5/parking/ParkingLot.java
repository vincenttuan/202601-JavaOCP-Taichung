package day5.parking;

// 停車場
public class ParkingLot {
	
	// 停車紀錄陣列
	private ParkingRecord[] spaces;;
	
	// lots 停車場車位數量
	public ParkingLot(int lots) {
		spaces = new ParkingRecord[lots];
	}
	
	// 顯示停車場空位資訊
	public void showParkingLot() {
		System.out.println("\n====== 停車場狀況 ======");
		// 顯示車格編號
		System.out.print("車格: ");
		for(int i=0;i<spaces.length;i++) {
			System.out.printf("%-4d", i);
		}
		System.out.println();
		System.out.println("      --------------------------------------");
		// 顯示是否有車
		System.out.print("狀態: ");
		for(int i=0;i<spaces.length;i++) {
			System.out.printf("%-4s", spaces[i]==null?"":"V");
		}
		System.out.println();
		System.out.println("(V = 有車, 空白 = 空位)");
	}
	
	// 找空位
	// 若有找到會回傳 0~n 的任一值
	// 沒有空位則回傳 -1
	public int findEmptySpace() {
		for(int i=0;i<spaces.length;i++) {
			if(spaces[i] == null) {
				return i;
			}
		}
		return -1;
	}
	
	// 停車
	public boolean parking(Vehicle vehicle, int ratePerSecond) {
		// 找空位
		int spaceNumber = findEmptySpace();
		
		// 判斷
		if(spaceNumber == -1) {
			System.out.println("停車場已滿");
			return false;
		}
		
		// 建立停車紀錄
		ParkingRecord record = new ParkingRecord(vehicle, spaceNumber, ratePerSecond);
		
		// 將[停車紀錄]放到[停車紀錄陣列]中
		spaces[spaceNumber] = record;
		System.out.printf("停車成功 -> 停車紀錄 -> %s%n", record);
		
		return true;
	}
}
