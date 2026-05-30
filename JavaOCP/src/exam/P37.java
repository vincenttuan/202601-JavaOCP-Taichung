package exam;

import java.util.ArrayList;

// var 只能用在區域變數
public class P37 {
	
	//var x; // 物件變數不可用 var
	
	public static void main(String[] args) {
		var h = 180; // var 可以在區域變數
		
		for(var i=0;i<10;i++) { // var 可以在區域變數
			System.out.println(i);
		}
		
		var names = new ArrayList<String>(); // var 可以在區域變數
		names.add("Java");
		names.add("Scale");
		names.forEach((var name) -> System.out.println(name));
	}
	
	/* 方法回傳值型態不可以是 var
	public var toString() {
		 return "func";
	}
	*/
	
	/* 方法參數型別不可以是 var
	public void setModel(var model) {
	
	}
	*/
}
