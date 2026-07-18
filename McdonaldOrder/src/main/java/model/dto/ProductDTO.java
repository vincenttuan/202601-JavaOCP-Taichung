package model.dto;

import lombok.Data;

/**
 * ProductDTO
 * 負責 Controller 與 Service 之間的資料傳遞
 * 
 * */
@Data
public class ProductDTO {
	
	private Long id;
	private String name;
	private String category;
	private Integer price;
	private Integer stock;
	private String imageBase64;
	private String imageType;
	
}
