package day13.play;

public class Main {
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Player("小明"));
		Thread t2 = new Thread(new Player("小華"));
		
		t1.start();
		t2.start();
		
	}
}
