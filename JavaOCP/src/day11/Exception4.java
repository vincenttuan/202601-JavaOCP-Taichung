package day11;

public class Exception4 {
	
	public static void main(String[] args) {
		
		try {
			action();
		} catch (ArithmeticException e) {
			System.out.println("數學錯誤");
			System.out.println("錯誤原因:" + e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("陣列錯誤");
			System.out.println("錯誤原因:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("其他錯誤");
			System.out.println("錯誤原因:" + e.getMessage());
		}
		
	}
	
	public static void action() {
		
		int[] arr = {10, 0, 5, 2};
		
		int a = arr[0]; // 分子
		int b = arr[4]; // 分母
			
		int result = a / b;
			
		System.out.println(result);
		
	}
}
