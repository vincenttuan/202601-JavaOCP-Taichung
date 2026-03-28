package day8.case1;

// 外部類別
public class Outer {
	public int x = 7; // Outer 的物件變數
	public static int sx = 9; // Outer 的類別變數
	// 內部類別
	public class Inner {
		public int x = 77; // Inner 的物件變數
		//public static int sx = 99; // Inner 的類別變數(Java16+以後才可以宣告)
		public void info() {
			int x = 777; // info() 方法的區域變數
			System.out.println("我是內部類別");
			System.out.println(x); // 777
			System.out.println(this.x); // 77
			//System.out.println(Inner.this.x); // 77
			System.out.println(Outer.this.x); // 7
			System.out.println(Outer.sx);
			//System.out.println(Inner.sx);
		}
		
	}
	
	// 物件方法
	public void service(int hours) {
		
		int rate = 30; // 每小時 30 元
		
		// 方法內部類別
		class Parking {
			int calculateFee() {
				return rate * hours;
			}
			
			void printBill() {
				System.out.printf("停車時數: %d%n", hours);
				System.out.printf("每小時費用: %d%n", rate);
				System.out.printf("總費用: %d%n", calculateFee());
			}
		}
		
		
		// 使用方法內部類別
		Parking parking = new Parking();
		parking.printBill();
		
		
		
	}
	
	// 匿名內部類別 - VIP 折扣計算
	interface VIPCalculator {
		int calculate(int h, int r);
	}
	
	public void vipService(int hours) {
		
		int rate = 30; // 每小時 30 元
		
		VIPCalculator vip = new VIPCalculator() {
			@Override
			public int calculate(int h, int r) {
				// VIP 8 小時以內免費, 超過 8 小時每小時半價
				if(h <= 8) {
					return 0; // 8 小時以內免費
				}
				int extraHours = h - 8;
				return (int)(extraHours * r * 0.5); // 超過 8 小時每小時半價
			}
		};
		
		int fee = vip.calculate(hours, rate);
		System.out.printf("VIP 停車時數: %d 小時, 費用: %d 元%n", hours, fee);
		
	}
	
	
}
