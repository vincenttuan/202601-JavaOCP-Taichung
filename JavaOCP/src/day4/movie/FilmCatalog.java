package day4.movie;

// 電影資料庫
public class FilmCatalog {
	
	// 定義電影
	private static final Movie TEAMS = new Movie("復仇者聯盟4", "2hr30m");
	private static final Movie GIRLS = new Movie("陽光女子合唱團", "2hr10m");
	
	// 定義電影廳
	private static final Hall A = new Hall(TEAMS, "A", "iMax");
	private static final Hall B = new Hall(TEAMS, "B", "3D");
	private static final Hall C = new Hall(GIRLS, "C", "普通");
	
	// 定義可訂座位
	private static final Seat[] SEATS = {
			new Seat(A, 1, 250), //0: A廳(放映復仇者聯盟4) 1排 $250元
			new Seat(A, 2, 240), //1: A廳(放映復仇者聯盟4) 2排 $240元
			new Seat(B, 3, 220), //2: B廳(放映復仇者聯盟4) 3排 $220元
			new Seat(C, 2, 260), //3: C廳(陽光女子合唱團)  2排 $260元
	};
	
	// 根據 index 找到可訂座位
	public static Seat findByIndex(int index) {
		return SEATS[index];
	}
	
	// 電影座位表(取得所有可訂座位清單)
	public static String[] getAvailableSeats() {
		String[] list = new String[SEATS.length];
		for(int i=0;i<SEATS.length;i++) {
			list[i] = SEATS[i].displayName();
		}
		return list;
	}
}
