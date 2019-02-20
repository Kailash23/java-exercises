package model;

public class Product {

	private int itemId;
	private String productName;
	private int price;
	private String desc;
	private int category;
	
	public Product(int itemId, String productName, int price, String desc, int category) {
		this.itemId = itemId;
		this.productName = productName;
		this.price = price;
		this.desc = desc;
		this.category = category;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

}
	
