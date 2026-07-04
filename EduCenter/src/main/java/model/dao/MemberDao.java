package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.Member;
import model.util.DBUtil;
import model.util.SHA256Util;

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
			pstmt.setString(2, SHA256Util.hash(member.getPassword())); // 密碼要轉雜湊
			pstmt.setString(3, member.getFullname());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getRole());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
	}
	
	/**
	 * 登入
	 * */
	public Member login(String username, String password) {
		
		// 明碼的密碼要轉 hash
		password = SHA256Util.hash(password);
		
		String sql = """
				select id, username, password, fullname, email, role, create_time from member where username = ?
				""";
		
		try(Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, username);
			
			try(ResultSet rs = pstmt.executeQuery()) {
				
				// 1.查無該使用者
				if(!rs.next()) {
					return null;
				}
				
				// 2.密碼比對錯誤
				if(!password.equals(rs.getString("password"))) {
					return null;
				}
				
				// 3.登入成功將 member 物件回傳
				Member member = new Member();
				member.setId(rs.getInt("id"));
				member.setUsername(rs.getString("username"));
				member.setPassword(rs.getString("password"));
				member.setFullname(rs.getString("fullname"));
				member.setEmail(rs.getString("email"));
				member.setRole(rs.getString("role"));
				member.setCreateTime(rs.getDate("create_time"));
				
				return member;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	/**
	 * 查詢全部會員資料
	 * */
	public List<Member> findAll() {
		List<Member> members = new ArrayList<>();
		
		String sql = "select id, username, password, fullname, email, role, create_time from member";
		
		try(Connection conn = DBUtil.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);) {
			
			// 將資料表所查詢到的資訊一個一個放到 members 集合中
			while (rs.next()) {
				// 建立 member 物件, 並將欄位資料放入指定的物件屬性中
				Member member = new Member();
				member.setId(rs.getInt("id"));
				member.setUsername(rs.getString("username"));
				member.setPassword(rs.getString("password"));
				member.setFullname(rs.getString("fullname"));
				member.setEmail(rs.getString("email"));
				member.setRole(rs.getString("role"));
				member.setCreateTime(rs.getDate("create_time"));
				
				// 注入到集合
				members.add(member);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return members;
	}
	
	/**
	 * 修改會員資料
	 * 除了 id, username, create_time 不可修改
	 * 其他欄位都可以修改
	 * */
	public void update(Integer id, String password, String fullname, String email, String role) {
		
		String sql = """
					update member 
					set password=?, fullname=?, email=?, role=? 
					where id=?
				""";
		
		try(Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			// ? 內容匹配
			pstmt.setString(1, password);
			pstmt.setString(2, fullname);
			pstmt.setString(3, email);
			pstmt.setString(4, role);
			pstmt.setInt(5, id);
			
			// 執行更新
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * 刪除會員
	 * */
	public void delete(Integer id) {
		String sql = "delete from member where id=?";
		
		try(Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			pstmt.setInt(1, id);
			
			// 執行更新
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}















