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
		//Vehicle v1 = new Car(); // 利用 Vehicle 來宣告 car, 所以只能使用 Vehicle 的資源
		//Vehicle v2 = new Bike(); // 利用 Vehicle 來宣告 bike, 所以只能使用 Vehicle 的資源
		Vehicle v1 = car; // 利用 Vehicle 來宣告 car, 所以只能使用 Vehicle 的資源
		Vehicle v2 = bike; // 利用 Vehicle 來宣告 bike, 所以只能使用 Vehicle 的資源
		
		System.out.printf("車牌: %s%n", v1.getPlateNumber());
		System.out.printf("車牌: %s%n", v2.getPlateNumber());
		
		
		
	}

}
