package exam;

import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

public class P26 {
	public static void main(String[] args) {
		String message = "Java11";
		
		Print p1 = new PrintImpl();
		Print p2 = new PrintImpl2();
		
		p1.print(message);
		p2.print(message);
		
		System.out.println("===================");
		
		ServiceLoader<Print> loader = ServiceLoader.load(Print.class);
		
		try {
			Iterator<Print> printers = loader.iterator();
			while(printers.hasNext()) {
				Print printer = printers.next();
				printer.print(message);
			}
		} catch (ServiceConfigurationError serviceError) {
			System.out.println(serviceError);
			serviceError.printStackTrace();
		}
		
		
	}
}
