package model;

public class ItemDetails {

	private int itemId;
	private String productName;
	private int price;
	private int discount;
	private int category;
	
	public ItemDetails(int itemId, String productName, int price, int discount, int category) {
		this.itemId = itemId;
		this.productName = productName;
		this.price = price;
		this.discount = discount;
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

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}
}
