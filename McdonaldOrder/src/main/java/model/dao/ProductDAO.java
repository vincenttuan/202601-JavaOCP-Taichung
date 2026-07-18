package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.Product;
import util.DBUtil;

/**
 * ProductDAO
 * 負責 JDBC 與 SQL
 * 資料使用 Product (Entity)
 * */
public class ProductDAO {
	
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
	
}
