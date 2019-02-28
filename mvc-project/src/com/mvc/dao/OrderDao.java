package com.mvc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.model.Order;

public class OrderDao {

	private List<Order> orderList = new ArrayList<>();

	public Order getOrderById(int orderId) {
		try {
			PreparedStatement ps = DbConnection.getConnection()
					.prepareStatement("select * from orders where orderId=" + orderId);
			ResultSet rs = ps.executeQuery();
			if (rs.first()) {
				return new Order(rs.getInt("orderId"), rs.getInt("amount"), rs.getString("time"),
						rs.getInt("noOfItems"));
			} else {
				System.out.println("No order present with this order id!");
			}
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Order> getOrderList() {

		try {
			PreparedStatement ps = DbConnection.getConnection().prepareStatement("select * from orders");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				orderList.add(new Order(rs.getInt("orderId"), rs.getInt("amount"), rs.getString("time"),
						rs.getInt("noOfItems")));
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orderList;
	}

	public void addOrder(Order order) {
		try {
			int orderId = order.getOrderId();
			int amount = order.getAmount();
			String time = order.getTime();
			int noOfItem = order.getNoOfItems();
			String query = "INSERT INTO orders (orderId, amount, time, noOfItems) VALUES ('" + orderId + "','" + amount
					+ "', '" + time + "', '" + noOfItem + "');";
			PreparedStatement ps = DbConnection.getConnection().prepareStatement(query);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void removeOrder(int orderId) {
		try {
			PreparedStatement ps = DbConnection.getConnection()
					.prepareStatement("select * from orders where orderId=" + orderId);
			ResultSet rs = ps.executeQuery();
			if (rs.first()) {
				PreparedStatement ps1 = DbConnection.getConnection()
						.prepareStatement("delete * from orders where orederId=" + orderId);
				ps1.executeQuery();
			} else {
				System.out.println("Order did't exist, hence can't be delete!");
			}
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
