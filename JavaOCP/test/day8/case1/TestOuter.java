package day8.case1;

public class TestOuter {

	public static void main(String[] args) {
		// 建立外部類別實體
		Outer ou = new Outer();
		// 透過 ou 建立內部類別實體
		Outer.Inner in = ou.new Inner();
		// 調用內部類的實體方法
		in.info();
	}

}
