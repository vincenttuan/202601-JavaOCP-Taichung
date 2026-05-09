package day13.travel;

public class Main {
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Traveler(), "小明");
		Thread t2 = new Thread(new Traveler(), "小華");
		Thread t3 = new Thread(new Traveler(), "小英");
		
		t1.start();
		t2.start();
		t3.start();
		
	}
}
