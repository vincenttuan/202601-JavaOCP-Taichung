package exam;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class P02 {

	public static void main(String[] args) {
		List<String> drawing = List.of("border", "outline", "accent", "limit");
		//Comparator<String> c1 = (a, b) -> b.compareTo(a);  // 大 -> 小
		Comparator<String> c1 = (a, b) -> a.compareTo(b);  // 小 -> 大 
        Comparator<String> c2 = c1.reversed();
        String strDrawing = drawing.stream().sorted(c2).collect(Collectors.joining(" "));
        System.out.println(strDrawing);

	}

}
