package day7.case2;

public abstract class AbstractCup implements Cup {
	protected String name; // protected 表示該資源可以給子類別或在同一層 package 的 class 使用

	@Override
	public void fill() {
		System.out.println(name + "可裝水" + Cup.capacity + "cc");
	}
	
	// 自訂一個額外工序的抽象方法
	protected abstract void extraProcess();
	
}
