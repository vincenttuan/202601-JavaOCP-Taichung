package day3;

public class StringDemo2 {

	public static void main(String[] args) {
		String s1 = new String("Java");
		String s2 = new String("Java");
		String s3 = "Java";
		String s4 = "Java";
		String s5 = "  Java ";
		
		System.out.printf("s1 == s2 %b%n", s1 == s2);
		System.out.printf("s3 == s4 %b%n", s3 == s4);
		System.out.printf("s1.equals(s2) %b%n", s1.equals(s2));
		System.out.printf("s3.equals(s4) %b%n", s3.equals(s4));
		System.out.printf("s1.equals(s3) %b%n", s1.equals(s3));
		System.out.printf("s4.equals(s5) %b%n", s4.equals(s5));
		System.out.printf("s1.equals(s5) %b%n", s1.equals(s5));
		// trim() 去除左右空白
		System.out.printf("去空白後比較 s1.equals(s5.trim()) %b%n", s1.equals(s5.trim()));
		
		

	}

}
