package service;

import java.util.List;

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
	
	public List<ProductDTO> findAll() {
		return productDAO.findAll()
						.stream()
						.map(this::toDTO)
						.toList();
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
	
	// 轉 dto
	private ProductDTO toDTO(Product product) {
		ProductDTO dto = new ProductDTO();
		
		dto.setId(product.getId());
		dto.setName(product.getName());
		dto.setCategory(product.getCategory());
		dto.setPrice(product.getPrice());
		dto.setStock(product.getStock());
		dto.setImageBase64(product.getImageBase64());
		dto.setImageType(product.getImageType());
		
		return dto;
	}
	
}
