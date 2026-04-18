package day10.entity;

public class Product {
	private Integer id;
	private String name;
	private Integer price;
	private Integer amount;
	
	public Product() {
		
	}
	
	public Product(Integer id, String name, Integer price, Integer amount) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.amount = amount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", amount=" + amount + "]";
	}
	
	
	
}
