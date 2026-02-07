package day3;

public class StringDemo1 {

	public static void main(String[] args) {
		String s1 = new String("Java");
		String s2 = new String("Java");
		String s3 = new String("jAvA");
		
		System.out.printf("s1 = %s%n", s1);
		System.out.printf("s2 = %s%n", s2);
		System.out.printf("s3 = %s%n", s3);
		System.out.printf("s1 == s2 %b%n", s1 == s2);
		System.out.printf("s1.equals(s2) %b%n", s1.equals(s2));
		System.out.printf("s1.equals(s3) %b%n", s1.equals(s3));
		// 不分大小寫比較
		System.out.printf("s1.equalsIgnoreCase(s3) %b%n", s1.equalsIgnoreCase(s3));
		
		

	}

}
