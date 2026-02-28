package day4.movie;

// 電影資料庫
public class FilmCatalog {
	
	// 定義電影
	private static final Movie TEAMS = new Movie("復仇者聯盟4", "2hr30m");
	private static final Movie GIRLS = new Movie("陽光女子合唱團", "2hr10m");
	
	// 定義電影廳
	private static final Hall[] HALLS = {
			new Hall(TEAMS, "A", "iMax"),  // HALLS[0]
			new Hall(TEAMS, "B", "3D"),    // HALLS[1]
			new Hall(GIRLS, "C", "普通")    // HALLS[2]
	};
	
	// 定義座位
	private static final Seat[] SEATS = {
			new Seat(HALLS[0], 1, 250), //0: A廳(放映復仇者聯盟4) 1排 $250元
			new Seat(HALLS[0], 2, 240), //1: A廳(放映復仇者聯盟4) 2排 $240元
			new Seat(HALLS[1], 3, 220), //2: B廳(放映復仇者聯盟4) 3排 $220元
			new Seat(HALLS[2], 2, 260), //3: C廳(陽光女子合唱團) 2排 $260元
	};
	
	public static Seat findByIndex(int index) {
		return SEATS[index];
	}
	
}
