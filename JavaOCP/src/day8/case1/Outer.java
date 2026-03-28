package day8.case1;

// 外部類別
public class Outer {
	public int x = 7; // Outer 的物件變數
	// 內部類別
	public class Inner {
		public int x = 77; // Inner 的物件變數
		public void info() {
			int x = 777; // info() 方法的區域變數
			System.out.println("我是內部類別");
			System.out.println(x); // 777
			System.out.println(this.x); // 77
			//System.out.println(Inner.this.x); // 77
			System.out.println(Outer.this.x); // 7
		}
		
	}
	
}
