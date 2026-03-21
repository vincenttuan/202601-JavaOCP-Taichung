package day7.case2;

/**
 * 強迫規定杯子的容量
 * 定義杯子一定要能做的事
 * 
 *                +-----+
 *                | Cup |  <interface>
 *                +-----+
 *                   ^
 *                   |   implements
 *            +-------------+ 
 *            | AbstractCup | <abstract class>
 *            +-------------+  
 *                 ^   ^
 *                 |   |  extends         
 *      +----------+   +-----+
 *      | PaperCup |   | Mug |  <class>
 *      +----------+   +-----+
 * */
public interface Cup {
	// 介面屬性一定會加入 public static final
	// 若沒有 java 會在編譯時期自動補上, 所以不寫也可以
	//public static final int capacity = 250; // cc
	int capacity = 250; // cc (java 會在編譯時期自動補上 public static final)
	
	void make(); // 製作方式 => public abstract void make();
	void fill(); // 裝水    => public abstract void fill();
	
}
