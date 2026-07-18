package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.entity.Product;
import util.DBUtil;

/**
 * ProductDAO
 * 負責 JDBC 與 SQL
 * 資料使用 Product (Entity)
 * */
public class ProductDAO {
	
	public void insert(Product product) {
		String sql = """
				insert into product(name, category, price, stock, image_base64, image_type)
				values(?, ?, ?, ?, ?, ?)
				""";
		
		try(Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setLong(1, product.getId());
			pstmt.setString(2, product.getName());
			pstmt.setInt(3, product.getPrice());
			pstmt.setInt(4, product.getStock());
			pstmt.setString(5, product.getImageBase64());
			pstmt.setString(5, product.getImageType());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
