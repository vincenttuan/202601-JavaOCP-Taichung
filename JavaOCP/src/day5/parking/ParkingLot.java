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
		
		int parkedCount = 0; // 已停車數
		int emptyCount = 0;  // 空位數
		
		System.out.println("\n====== 停車場狀況 ======");
		// 顯示車格編號
		System.out.print("車格: ");
		for(int i=0;i<spaces.length;i++) {
			System.out.printf("%-4d", i);
		}
		System.out.println();
		System.out.println("    ----------------------------------------");
		// 顯示是否有車
		System.out.print("狀態: ");
		for(int i=0;i<spaces.length;i++) {
			//System.out.printf("%-4s", spaces[i]==null?"":"V");
			if(spaces[i] == null) {
				System.out.printf("%-4s", "");
				emptyCount++;
			} else {
				System.out.printf("%-4s", "V");
				parkedCount++;
			}
		}
		System.out.println();
		System.out.printf("(V = 有車(%d), 空白 = 空位(%d))%n", parkedCount, emptyCount);
		System.out.println();
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
		
		// 檢查是否重複車牌
		if(existsCar(vehicle.getPlateNumber())) {
			System.out.printf("停車失敗 -> 車牌已存在:%s%n", vehicle.getPlateNumber());
			return false;
		}
		
		// 建立停車紀錄
		ParkingRecord record = new ParkingRecord(vehicle, spaceNumber, ratePerSecond);
		
		// 將[停車紀錄]放到[停車紀錄陣列]中
		spaces[spaceNumber] = record;
		System.out.printf("停車成功 -> 停車紀錄 -> %s%n", record);
		
		return true;
	}
	
	// 取車繳費
	public void removeCar(String plateNumber) {
		for(int i=0;i<spaces.length;i++) {
			ParkingRecord record = spaces[i];
			if(record == null) {
				continue;
			}
			// 從停車紀錄中取出車輛
			Vehicle vehicle = record.getVehicle();
			// 比對 plateNumber
			if(vehicle.getPlateNumber().equals(plateNumber)) {
				System.out.println("取車成功:");
				record.showInfo(); // 顯示停車相關資訊與費用
				// 將空位釋出
				spaces[i] = null;
				return;
			}
		}
		System.out.printf("取車失敗 -> 無此車號:%s%n", plateNumber);
		return;
	}
	
	// 檢查車牌是否已在停車場
	public boolean existsCar(String plateNumber) {
		for(ParkingRecord record : spaces) {
			if(record == null) {
				continue;
			}
			// 比對車牌
			if(record.getVehicle().getPlateNumber().equals(plateNumber)) {
				return true;
			}
		}
		return false;
	}
	
}





