package day4;

// 電影基本資料
public class Movie {
	
	// 物件屬性
	private String title; // 片名
	private String duration; // 片長
	
	// 建構子
	public Movie(String title, String duration) {
		this.title = title;
		this.duration = duration;
	}
	
	// getters
	public String getTitle() {
		return title;
	}

	public String getDuration() {
		return duration;
	}
	
	
}
