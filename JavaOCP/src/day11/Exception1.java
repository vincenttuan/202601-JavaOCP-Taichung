package day11;

// 在 java 中. try-catch 是用來處理例外(Exception)的機制
// 避免程式在發生錯誤時直接崩潰
public class Exception1 {

	public static void main(String[] args) {
		
		try {
			int a = 10;
			int b = 0;
			int result = a / b;
			System.out.println(result);
			
		} catch (ArithmeticException e) {
			System.out.println("發生錯誤");
			System.out.println("錯誤原因:" + e);
			System.out.println("錯誤原因:" + e.getMessage());
		}
		
		System.out.println("程式可以繼續執行...");
		
		//---------------------------------------------------
		
		int c = 10;
		int d = 0;
		// 補強檢查邏輯
		if(d == 0) {
			System.out.println("分母不可為 0");
			return;
		}
		int result2 = c / d;
		System.out.println(result2);
		
		
	}

}
