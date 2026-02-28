package day4;

// 電影播放廳
public class Hall {
	
	// 物件屬性
	private Movie movie; // 要播放的電影
	private String code; // 廳代碼: A, B, C
	private String name; // 廳名稱: iMax廳, 3D廳, 普通廳
	
	public Hall(Movie movie, String code, String name) {
		super();
		this.movie = movie;
		this.code = code;
		this.name = name;
	}

	public Movie getMovie() {
		return movie;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
	
}
