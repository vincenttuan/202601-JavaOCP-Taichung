package day6;

// 支付/結帳方式
// submit() 的方法設計稱為超載 Overloading 
public class Payment {
	
	public void submit(int cash) {
		System.out.printf("現金交易: $%d%n", cash);
	}
	
	public void submit(int cash, String eType) {
		System.out.printf("電子交易: %s $%d%n", eType, cash);
	}
	
	public void submit(int cash, String cardNo, int code) {
		System.out.printf("信用卡交易: 卡號: %s 末三碼: %d $%d%n", cardNo, code, cash);
	}
	
	public void submit() {
		System.out.println("免費");
	}
	
}
