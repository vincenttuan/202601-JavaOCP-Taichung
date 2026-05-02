package day12;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.function.Supplier;

/**
 * 
 * Supplier 供應
 * 
 * 沒有輸入 -> 只負責提供資料
 * 
 @FunctionalInterface
 public interface Supplier<T> {
    T get();
 }
 * */

public class TestSupplier {
	
	public static void main(String[] args) {
		
		// 產生幸運數字
		Supplier<Integer> luckyNumber = () -> new Random().nextInt(99) + 1; // 1~99
		System.out.println(luckyNumber.get());
		
		// 產生現在時間
		Supplier<LocalDateTime> now = () -> LocalDateTime.now();
		System.out.println(now.get());
	}
	
}
