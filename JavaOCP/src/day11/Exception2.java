package day11;

public class Exception2 {

	public static void main(String[] args) {
		
		int[] arr = {10, 0, 5, 2};
		
		try {
			
			int a = arr[0]; // 分子
			int b = arr[4]; // 分母
			
			int result = a / b;
			
			System.out.println(result);
			
		} catch (Exception e) {
			System.out.println("錯誤類型:" + e.getClass().getSimpleName());
			switch (e.getClass().getSimpleName()) {
				case "ArithmeticException":
					System.out.println("數學錯誤");
					System.out.println("錯誤原因:" + e.getMessage());
					break;
				case "ArrayIndexOutOfBoundsException":
					System.out.println("陣列錯誤");
					System.out.println("錯誤原因:" + e.getMessage());
					break;
				default:
					System.out.println("其他錯誤");
					System.out.println("錯誤原因:" + e.getMessage());
			}
		}
		
	}
}
