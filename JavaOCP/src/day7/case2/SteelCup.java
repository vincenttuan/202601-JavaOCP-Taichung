package day7.case2;

public class SteelCup extends AbstractCup {
	
	public SteelCup(String name) {
		this.name = name;
	}

	@Override
	public void make() {
		System.out.println("準備製作:" + name);
		System.out.println("杯子容量:" + Cup.capacity);
		System.out.println("切割不銹鋼材");
		System.out.println("沖壓成型");
		extraProcess(); // 呼叫額外工序
		System.out.println("拋光處理");
		System.out.println("製作完成");
	}

	@Override
	protected void extraProcess() {
		System.out.println("耐熱測試");
	}
	
	
}
