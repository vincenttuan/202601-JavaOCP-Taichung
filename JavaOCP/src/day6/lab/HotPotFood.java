package day6.lab;

public class HotPotFood extends Food {
	@Override
	public void prepare() {
		System.out.println("開火-煮水");
	}
	
	@Override
	public void order() {
		System.out.println("麻辣鴨血一份");
	}
}
