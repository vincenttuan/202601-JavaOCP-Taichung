package day9;

import java.util.HashSet;
import java.util.Set;

public class SetDemo3 {

	public static void main(String[] args) {
		// 集合泛型的應用
		// Set 集合不適合放分數適合放科目
		// 避免放入非 String 之外的資訊
		// 透過 <> 泛型來做限制設定
		// Set<String> set1 = new HashSet<String>();
		Set<String> set1 = new HashSet<>();
		set1.add("國");
		//set1.add(90);
		set1.add("數");
		set1.add("英");
		//set1.add(100);
		//set1.add(90);
		
		System.out.println(set1);
	}

}
