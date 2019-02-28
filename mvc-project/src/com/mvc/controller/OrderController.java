package com.mvc.controller;

import java.util.List;

import com.mvc.model.Order;
import com.mvc.model.Product;
import com.mvc.service.OrderService;



public class OrderController {

	private OrderService orderService = new OrderService();

	public void placeOrder(List<Product> cartProductList) {
		orderService.addOrder(cartProductList);
	}

	public Order getOrderById(int orderId) {
		return orderService.getOrderBytId(orderId);
	}
	
	public List<Order> viewOrders() {
		List<Order> orderList = orderService.getOrderList();
		return orderList;
	}
	
	public void deleteOrder(int orderId) {
		orderService.removeOrder(orderId);
	}
	
}
