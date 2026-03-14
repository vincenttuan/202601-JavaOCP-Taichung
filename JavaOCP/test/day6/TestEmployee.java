package day6;

public class TestEmployee {

	public static void main(String[] args) {
		Employee emp1 = new Manager();
		System.out.println(emp1.getClass().getSimpleName());
		System.out.println("薪資:" + emp1.getSalary());
		// 轉型前判斷
		if(emp1 instanceof Manager) {
			System.out.println("預算:" + ((Manager)emp1).getBudget());
		}
		// 轉型前判斷
		if(emp1 instanceof Boss) {
			System.out.println("股票:" + ((Boss)emp1).getStock());
		}
	}

}
