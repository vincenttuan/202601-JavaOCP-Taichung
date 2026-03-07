package day5.parking;

public class Test {

	public static void main(String[] args) {
		// 封裝/繼承測試
		Car car = new Car();
		car.setSeats(4); // 方法封裝測試
		car.setPlateNumber("1234-AB"); // 繼承+方法封裝測試
		
		Bike bike = new Bike();
		bike.setElectric(true); // 方法封裝測試
		bike.setPlateNumber("5678-XY"); // 繼承+方法封裝測試
		
		System.out.printf("車牌: %s 座位數: %d%n", car.getPlateNumber(), car.getSeats());
		System.out.printf("車牌: %s 電動車: %b%n", bike.getPlateNumber(), bike.isElectric());
		
		// 多型測試

	}

}
