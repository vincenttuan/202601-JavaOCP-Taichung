package exam;

import java.util.stream.IntStream;

public class P24 {
	public static void main(String[] args) {
		IntStream.range(0, 5)
				 .forEach(n -> System.out.println(n));
	}
}
