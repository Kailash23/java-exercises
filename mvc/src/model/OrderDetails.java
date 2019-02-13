package model;

public class OrderDetails {

	private int orderId;
	private int amount;
	private String time;
	private int noOfItems;
	
	public OrderDetails(int orderId, int amount, String time, int noOfItems) {
		this.orderId = orderId;
		this.amount = amount;
		this.time = time;
		this.noOfItems = noOfItems;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getNoOfItems() {
		return noOfItems;
	}

	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}
	
}
