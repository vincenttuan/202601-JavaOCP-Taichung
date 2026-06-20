package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.entity.Member;
import model.util.DBUtil;

public class MemberDao {
	
	// ===== Singleton 單例模式 =====
	private static MemberDao instance = new MemberDao();
	
	private MemberDao() {
		
	}
	
	public static MemberDao getInstance() {
		return instance;
	}
	
	/**
	 * 新增會員(註冊)
	 * */
	public void register(Member member) {
		String sql = """
				insert into member (username, password, fullname, email, role)
				values(?, ?, ?, ?, ?)
				""";
		
		try(Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, member.getUsername());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getFullname());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getRole());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
