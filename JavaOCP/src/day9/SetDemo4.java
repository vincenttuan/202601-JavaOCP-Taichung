package day9;

import java.util.HashSet;
import java.util.Set;

public class SetDemo4 {

	public static void main(String[] args) {
		// 集合的可變性
		Set set1 = new HashSet(); // 可變集合
		set1.add(100);
		set1.add(73);
		set1.add(80);
		
		Set set2 = Set.of(100, 73, 80); // 不可變集合
		
		System.out.println("set1: " + set1);
		System.out.println("set2: " + set2);
		
		//---------------------------------------
		System.out.println("-----------------------");
		// 增加集合/移除元素
		set1.add(95); // 可以正常加入元素
		set1.remove(100); // 可以正常移除元素
		System.out.println("set1: " + set1);
		
		set2.add(95); // 不可以加入元素
		set2.remove(100); // 不可以加入元素
		System.out.println("set2: " + set2);
		
	}

}
