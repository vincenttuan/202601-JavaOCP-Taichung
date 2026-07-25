package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.entity.Product;
import util.DBUtil;

/**
 * ProductDAO
 * 負責 JDBC 與 SQL
 * 資料使用 Product (Entity)
 * */
public class ProductDAO {
	
	// 查詢所有商品
	public List<Product> findAll() {
		List<Product> products = new ArrayList();
		
		String sql = """
				select id, name, category, price, stock, image_base64, image_type, create_at, update_at
				from product
				order by id
				""";
		
		try(Connection conn = DBUtil.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql)) {
			
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getLong("id"));
				product.setName(rs.getString("name"));
				product.setCategory(rs.getString("category"));
				product.setPrice(rs.getInt("price"));
				product.setStock(rs.getInt("stock"));
				product.setImageBase64(rs.getString("image_base64"));
				product.setImageType(rs.getString("image_type"));
				product.setCreateAt(rs.getTimestamp("create_at").toLocalDateTime());
				product.setUpdateAt(rs.getTimestamp("update_at").toLocalDateTime());
				
				products.add(product);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		
		return products;
	}
	
	// 新增商品
	public void insert(Product product) {
		String sql = """
				insert into product(name, category, price, stock, image_base64, image_type)
				values(?, ?, ?, ?, ?, ?)
				""";
		
		try(Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, product.getName());
			pstmt.setString(2, product.getCategory());
			pstmt.setInt(3, product.getPrice());
			pstmt.setInt(4, product.getStock());
			pstmt.setString(5, product.getImageBase64());
			pstmt.setString(6, product.getImageType());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		
	}
	
	// 刪除商品
	public int deleteById(Long id) {
		String sql = "delete from product where id = ?";
		
		try(Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setLong(1, id);
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException("刪除商品失敗, id=" + id);
		}
		
	}
	
	// 查詢單筆商品
	public Optional<Product> findById(long id) {
		String sql = """
				select id, name, category, price, stock, image_base64, image_type, create_at, update_at
				from product
				where id=?
				""";
		
		try(Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setLong(1, id);
			
			try(ResultSet rs = pstmt.executeQuery()) {
				
				if(rs.next()) {
					Product product = new Product();
					product.setId(rs.getLong("id"));
					product.setName(rs.getString("name"));
					product.setCategory(rs.getString("category"));
					product.setPrice(rs.getInt("price"));
					product.setStock(rs.getInt("stock"));
					product.setImageBase64(rs.getString("image_base64"));
					product.setImageType(rs.getString("image_type"));
					product.setCreateAt(rs.getTimestamp("create_at").toLocalDateTime());
					product.setUpdateAt(rs.getTimestamp("update_at").toLocalDateTime());
					
					return Optional.of(product);
				} 
			}
			
		} catch (SQLException e) {
			throw new RuntimeException("查詢商品失敗, id:" + id + ", 錯誤訊息:" + e.getMessage());
		}
		return Optional.empty();
	}
	
	// 修改商品
	public int update(Product product) {
		// 是否有此商品 ?
		if(findById(product.getId()).isEmpty()) {
			throw new RuntimeException("查無此商品, id:" + product.getId());
		}
		
		String sql = """
				update product
				set name=?, category=?, price=?, stock=?, image_base64=?, image_type=?
				where id=?
				""";
		
		try(Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, product.getName());
			pstmt.setString(2, product.getCategory());
			pstmt.setInt(3, product.getPrice());
			pstmt.setInt(4, product.getStock());
			pstmt.setString(5, product.getImageBase64());
			pstmt.setString(6, product.getImageType());
			pstmt.setLong(7, product.getId());
			
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException("修改商品失敗, id=" + product.getId() + ", 錯誤訊息:" + e.getMessage());
		}
		
	}
	
	
}
