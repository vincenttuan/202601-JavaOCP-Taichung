package day6.lab;

public class NightMarketFood extends Food {
	
	@Override
	public void prepare() {
		System.out.println("開火-熱鍋冷油");
	}
	
	@Override
	public void order() {
		System.out.println("雞排一份");
	}
	
}
