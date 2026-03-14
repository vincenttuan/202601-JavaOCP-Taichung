package day6.lab;

public class Food {
	public void prepare() {
		
	}
	
	public void serve() {
		System.out.println("上菜了~");
	}
	
	public void order() { // 預設一份
		System.out.println("預設餐 1 份");
	}
	
	public void order(String name) { // 指定食物名稱
		System.out.printf("%s餐 1 份%n", name);
	}
	
	public void order(String name, int quantity) { // 指定名稱 + 份量
		System.out.printf("%s餐 %d 份%n", name, quantity);
	}
}
