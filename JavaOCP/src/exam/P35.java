package exam;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class P35 {
	public static void main(String[] args) {
		// 設定 Locale (日本)
		Locale locale = Locale.JAPAN;
		
		// 載入 resource (注意命名: package + base name)
		// package -> exam
		// base name -> messages 
		ResourceBundle msg = ResourceBundle.getBundle("exam.messages", locale);
		
		// 取得 pattern
		String pattern = msg.getString("message");
		
		// 參數
		Object[] params = {"Hi", "Jane"};
		
		// 格式化
		String result = MessageFormat.format(pattern, params);
		
		System.out.println(result);
	}
}
