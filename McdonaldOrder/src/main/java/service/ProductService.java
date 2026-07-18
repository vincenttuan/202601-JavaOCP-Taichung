package service;

import model.dao.ProductDAO;
import model.dto.ProductDTO;
import model.entity.Product;

/**
 * Product Service
 * 負責資料驗證,商業流程與 DTO / Entity 之間的轉換
 * */
public class ProductService {
	
	private ProductDAO productDAO = new ProductDAO();
	
	public void create(ProductDTO dto) {
		// productDTO(DTO) 轉 product(Entity)
		Product product = toEntity(dto);
		// 儲存
		productDAO.insert(product);
	}
	
	// 轉 entity
	private Product toEntity(ProductDTO dto) {
		Product product = new Product();
		product.setId(dto.getId());
		product.setName(dto.getName());
		product.setCategory(dto.getCategory());
		product.setPrice(dto.getPrice());
		product.setStock(dto.getStock());
		product.setImageBase64(dto.getImageBase64());
		product.setImageType(dto.getImageType());
		return product;
	}
	
}
