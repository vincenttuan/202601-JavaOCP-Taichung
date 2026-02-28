package day4;

public class TestAccount {

	public static void main(String[] args) {
		System.out.println("測試資料");
		System.out.println("=================");
		
		// 建立二組帳號可以存/提/轉帳/列印資訊
		Account a = new Account("2026001", "John", 10000);
		Account b = new Account("2026002", "Mary", 10000);
		System.out.println(a); // 會自動呼叫 toString()
		System.out.println(b); // 會自動呼叫 toString()
		
		// John 存款 3000
		System.out.println("\nJohn 存款 3000:");
		a.deposit(3000);
		System.out.println(a);
		
		// Mary 提款 8000
		System.out.println("\nMary 提款 8000:");
		b.withdraw(8000);
		System.out.println(b);
		
		// John 轉給 Mary 5,500
		System.out.println("\nJohn 轉給 Mary 5,500:");
		a.transfer(5500, b);
		System.out.println(a);
		System.out.println(b);
	}

}
