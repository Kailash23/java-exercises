package com.mvc.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.mvc.dao.OrderDao;
import com.mvc.model.Order;
import com.mvc.model.Product;
import com.mvc.utils.Utils;



/**
 * @author kailash23
 *
 * 1 - Contains field related to order.
 * 2 - Should calls for generating order id to be filled in DB.
 * 3 - Save order to DB when successful.
 *
 */

public class OrderService {

	OrderDao orderDao = new OrderDao();
	
	public void addOrder(List<Product> cartList) {
		int pid = Utils.generateOrderId();
		int amount = 0;
		int noOfItems = cartList.size();
		String timeStamp = new SimpleDateFormat("dd-MM-yy HH:mm:ss").format(Calendar.getInstance().getTime());
		
		for (Product cartItem : cartList) {
			amount += cartItem.getPrice();
		}
	
		Order order = new Order(pid, amount, timeStamp, noOfItems);
		orderDao.addOrder(order);
	}
	
	public List<Order> getOrderList() {
		return orderDao.getOrderList();
	}
	
	public Order getOrderBytId(int orderId) {
		return orderDao.getOrderById(orderId);
	}
	
	public void removeOrder(int orderId) {
		orderDao.removeOrder(orderId);
	}
}