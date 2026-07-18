package model.entity;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * Product Entity
 * 對應 MySQL product 資料表
 * */
@Data
public class Product {
	private Long id;
	private String name;
	private String category;
	private Integer price;
	private Integer stock;
	private String imageBase64;
	private String imageType;
	private LocalDateTime createAt;
	private LocalDateTime updateAt;
}
