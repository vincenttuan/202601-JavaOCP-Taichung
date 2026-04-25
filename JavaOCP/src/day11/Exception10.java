package day11;

import java.util.Map;

/**
 * 寫一個登入系統
 * 成功: true
 * 失敗: 生成錯誤例外 + 錯誤原因 
 * 採用 Checked Exception, 強迫要進行錯誤處理
 * */
public class Exception10 {
	
	private static Map<String, String> userMap = Map.of("admin", "1234", "root", "12345678", "apple", "abc");
	
	public static void main(String[] args) {
		boolean check1 = false;
		try {
			check1 = checkLogin("admin", "1234");
		} catch (Exception e) {
			System.err.println("登入失敗! 原因:" + e.getMessage());
		}
		System.out.println("登入結果:" + check1);
		
		//-----------------------------------------------------
		boolean check2 = false;
		try {
			check2 = checkLogin("admin", "12345");
		} catch (Exception e) {
			System.err.println("登入失敗! 原因:" + e.getMessage());
		}
		System.out.println("登入結果:" + check2);
	}
	
	public static boolean checkLogin(String username, String password) throws Exception {
		// 1. 查 username
		if (userMap.get(username) == null) {
			//return false; // 查無使用者
			throw new Exception("查無使用者"); // 查無使用者
		}
		
		// 2. 比對 password
		if(!userMap.get(username).equals(password)) {
			//return false; // 密碼不正確
			throw new Exception("密碼不正確"); // 密碼不正確
		}
		
		// 3. 比對成功
		return true;
	}
	

}
