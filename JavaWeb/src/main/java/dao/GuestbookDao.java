package dao;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import entity.Guestbook;

/**
 * 此方法可以用來儲存/查詢訪客留言
 * 此類別是採用 SingleTon 的設計模式
 * 只會產生一個實體來共用
 * */
public class GuestbookDao {
	
	private static GuestbookDao _instance = new GuestbookDao();
	
	private GuestbookDao() {
		
	}
	
	public static GuestbookDao getInstance() {
		return _instance;
	}
	
	// 存放留言紀錄的集合
	private static List<Guestbook> guestbooks = new CopyOnWriteArrayList<>();
	
	// 新增留言紀錄
	public void add(String nickname, String content, String time) {
		Guestbook gb = new Guestbook();
		gb.setNickname(nickname);
		gb.setContent(content);
		gb.setTime(time);
		
		guestbooks.add(gb);
	}
	
	// 查詢所有留言紀錄
	public List<Guestbook> queryAll() {
		return guestbooks;
	}
	
	
}
