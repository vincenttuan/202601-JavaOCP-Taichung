package exam;

public class PrintImpl implements Print {
	
	public PrintImpl() {
		
	}
	
	@Override
	public void print(String message) {
		System.out.println("Print: " + message);
	}
}