package day3;

public class StringDemo3 {

	public static void main(String[] args) {
		// 陣列長度 length
		// 字串長度 length()
		String name = "John";
		System.out.printf("%s 的長度 = %d%n", name, name.length());
		
		// 包含 contain
		String menu = "雞腿飯,排骨飯,魚排飯,蝦捲飯,牛肉炒飯,羊肉炒麵";
		// menu 有包含"排骨飯"嗎 ?
		System.out.printf("有排骨飯嗎 ? %b%n", menu.contains("排骨飯"));
		System.out.printf("有排骨飯嗎 ? %s%n", (menu.contains("排骨飯") ? "有" : "沒有"));
		
		// menu 有包含"豬腳飯"嗎 ?
		System.out.printf("有豬腳飯嗎 ? %b%n", menu.contains("豬腳飯"));
		System.out.printf("有豬腳飯嗎 ? %s%n", (menu.contains("豬腳飯") ? "有" : "沒有"));
		
		// menu 有包含"炒麵"嗎 ?
		System.out.printf("有炒麵嗎 ? %b%n", menu.contains("炒麵"));
		System.out.printf("有炒麵嗎 ? %s%n", (menu.contains("炒麵") ? "有" : "沒有"));
	}

}
