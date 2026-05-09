package day13.play;

/**
 * 小明, 小華這二條執行緒同時執行run()方法, 試問誰先第一個取到 777 ?
 * 透過亂數若取到 777 則該執行緒程式停止
 * 若沒取到則需要再取亂數
 * 亂數
 * int x = (int)(Math.random() * 1000);

 * 執行結果範例 :
 * 小華 總共取了 261 次才得到 777
 * 小明 總共取了 724 次才得到 777
 * */
public class Player implements Runnable {
	
	private String name;
	
	public Player(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		int count = 0;
		while (true) {
			int x = (int)(Math.random() * 1000);
			count++;
			System.out.printf("[%d] %s 得到 %s%n", count, name);
			if(x == 777) {
				System.out.printf("\t%s 總共取了 %d 次才得到 777%n", name, count);
				break;
			}
		}
	}

}
