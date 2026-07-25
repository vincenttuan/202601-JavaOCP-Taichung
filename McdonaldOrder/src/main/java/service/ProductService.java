package service;

import java.util.List;
import java.util.Optional;

import model.dao.ProductDAO;
import model.dto.ProductDTO;
import model.entity.Product;

/**
 * Product Service
 * 負責資料驗證,商業流程與 DTO / Entity 之間的轉換
 * */
public class ProductService {
	
	private ProductDAO productDAO = new ProductDAO();
	
	// 新增商品
	public void create(ProductDTO dto) {
		// productDTO(DTO) 轉 product(Entity)
		Product product = toEntity(dto);
		// 儲存
		productDAO.insert(product);
	}
	
	// 查詢所有商品
	public List<ProductDTO> findAll() {
		return productDAO.findAll()
						.stream()
						.map(this::toDTO)
						.toList();
	}
	
	// 查詢指定商品
	public ProductDTO findById(long id) {
		Optional<Product> product = productDAO.findById(id);
		
		if(product.isEmpty()) {
			return null;
		}
		
		ProductDTO productDTO = toDTO(product.get());
		return productDTO;
	}
	
	// 刪除指定商品
	public void delete(long id) {
		int count = productDAO.deleteById(id);
		if(count != 1) {
			throw new IllegalArgumentException("找不到要刪除的商品, id=" + id);
		}
	}
	
	// 修改指定商品
	// hasNewImage 是否圖片有更新
	public void update(ProductDTO dto, boolean hasNewImage) {
		
		// 使用者未選新圖片時, 沿用資料庫原圖
		if(!hasNewImage) {
			
		}
		
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
