package day13.breakfast.normal;

public class Main {

	public static void main(String[] args) {
		OrderJob order = new OrderJob();
		CookJob cook = new CookJob();
		DrinkJob drink = new DrinkJob();
		
		order.work();
		cook.work();
		drink.work();

	}

}
