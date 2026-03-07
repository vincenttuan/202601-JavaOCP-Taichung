package day5.parking;

// 停車場
public class ParkingLot {
	
	// 停車位
	private ParkingRecord[] spaces = new  ParkingRecord[10];
	
	// 找空位
	// 若有找到會回傳 0~9 的任一值
	// 沒有空位則回傳 -1
	public int findEmptySpace() {
		for(int i=0;i<spaces.length;i++) {
			if(spaces[i] == null) {
				return i;
			}
		}
		return -1;
	}
	
	
}
