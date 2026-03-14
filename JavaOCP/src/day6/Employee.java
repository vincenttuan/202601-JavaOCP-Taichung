package day6;

public class Employee {
	// 薪資
	public int getSalary() {
		return 45000;
	}
	
}

class Manager extends Employee {
	// 預算
	public int getBudget() {
		return 10_0000;
	}
	
}

class Boss extends Employee {
	// 股票資產
	public int getStock() {
		return 500_0000;
	}
}

