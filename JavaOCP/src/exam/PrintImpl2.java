package exam;

public class PrintImpl2 implements Print {
	
	public PrintImpl2() {
	
	}
	
	@Override
	public void print(String message) {
		System.out.println("Print: " + message);
	}
}