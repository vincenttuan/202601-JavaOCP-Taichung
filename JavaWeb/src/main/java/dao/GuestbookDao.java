package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import entity.Guestbook;
import util.DBUtil;

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
	
	// 新增留言紀錄
	public void add(String nickname, String content, String time) {
		
		String sql = """
				insert into guestbook(nickname, content, create_time)
				values (?, ?, ?)
				""";
		
		try(Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, nickname);
			pstmt.setString(2, content);
			pstmt.setString(3, time);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// 查詢所有留言紀錄
	public List<Guestbook> queryAll() {
		List<Guestbook> guestbooks = new ArrayList<>();
		
		String sql = "select id, nickname, content, create_time from guestbook order by id";
		
		try(Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery()) {
			
			// 輪詢資料
			while(rs.next()) {
				Guestbook gb = new Guestbook();
				gb.setId(rs.getInt("id"));
				gb.setNickname(rs.getString("nickname"));
				gb.setContent(rs.getString("content"));
				gb.setTime(rs.getString("create_time"));
				// 將每一筆資料放入到集合中
				guestbooks.add(gb);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return guestbooks;
	}
	
	
}
