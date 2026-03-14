package day6;

public class TestEmployee {

	public static void main(String[] args) {
		Employee emp1 = new Manager();
		System.out.println(emp1.getSalary());
		System.out.println(((Manager)emp1).getBudget());

	}

}
