package exam;

import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

// 介面
interface Print {
	void print(String message);
}

// 實現類
class PrintImpl implements Print {
	@Override
	public void print(String message) {
		System.out.println("Print: " + message);
	}
}

public class P26 {
	public static void main(String[] args) {
		String message = "Java11";
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
