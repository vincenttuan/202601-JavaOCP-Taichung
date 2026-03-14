package day6;

public class TestEmployee {

	public static void main(String[] args) {
		Employee emp1 = new Manager();
		System.out.println(emp1.getClass().getSimpleName());
		System.out.println(emp1.getSalary());
		// 轉型前判斷
		if(emp1 instanceof Manager) {
			System.out.println(((Manager)emp1).getBudget());
		}
		// 轉型前判斷
		if(emp1 instanceof Boss) {
			System.out.println(((Boss)emp1).getStock());
		}
	}

}
