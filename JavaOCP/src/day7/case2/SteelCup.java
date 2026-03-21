package day7.case2;

import day7.case1.Cup;

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
		System.out.println("拋光處理");
		System.out.println("製作完成");
	}
	
	
}
