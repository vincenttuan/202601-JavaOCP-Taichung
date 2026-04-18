package day10;

import java.util.Stack;

public class ListDemo7 {

	public static void main(String[] args) {
		// Stack 的應用
		// LIFO -> 後進先出
		
		Stack<String> stack = new Stack<>();
		
		stack.push("a");
		stack.push("v");
		stack.push("a");
		stack.push("J");
		
		System.out.println(stack);
		
		while (!stack.isEmpty()) {
			String word = stack.pop();
			if(word != null) {
				System.out.print(word);
			}
		}
		
		System.out.println("\n" + stack);
		

	}

}
