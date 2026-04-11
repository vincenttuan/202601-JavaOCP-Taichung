package day9;

import java.util.Set; // interface
import java.util.HashSet; // 可以 new 的 class
import java.util.LinkedHashSet; // 可以 new 的 class
import java.util.TreeSet; // 可以 new 的 class

public class SetDemo1 {

	public static void main(String[] args) {
		// 探討不同 Set 集合應用
		// 將 [3] [8] [4] [5] 這四個元素依序放到 Set 集合中
		
		Set set1 = new HashSet();
		set1.add(3);set1.add(8);set1.add(4);set1.add(5);
		
		Set set2 = new LinkedHashSet();
		set2.add(3);set2.add(8);set2.add(4);set2.add(5);
		
		Set set3 = new TreeSet();
		set3.add(3);set3.add(8);set3.add(4);set3.add(5);
		
		System.out.println("將 [3] [8] [4] [5] 這四個元素依序放到 Set 集合中");
		System.out.println("HashSet(無序集合) => " + set1);
		System.out.println("LinkedHashSet(有序集合) => " + set2);
		System.out.println("TreeSet(排序集合) => " + set3);
	}

}
