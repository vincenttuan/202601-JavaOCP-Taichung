package day7.case1;

public class Mug implements Cup {
	private String name;
	
	public Mug(String name) {
		this.name = name;
	}

	@Override
	public void make() {
		System.out.println("準備製作:" + name);
		System.out.println("杯子容量:" + Cup.capacity);
		System.out.println("用陶瓷燒製成型");
		System.out.println("製作完成");
	}

	@Override
	public void fill() {
		System.out.println(name + "可裝水" + Cup.capacity + "cc");
	}
	
}
