package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Order;

/**
 * 
 * @author kailash23
 * 
 *         For User: getOrderList(param) - Contains method for fetching all
 *         previous orders of user
 * 
 *         For Admin: getAllOrder Admin can add product to product list Admin
 *         can edit the product details Admin can delete the product from list.
 */

public class OrderDao {

	private List<Order> orderList = new ArrayList<>();
	
	public Order getOrderById(int orderId) {
		try {
			PreparedStatement ps = DbConnection.getConnection().prepareStatement("select * from order where orederId=" + orderId);
			ResultSet rs = ps.executeQuery();
			if(rs.first()) {
				return new  Order(rs.getInt("orderId"), rs.getInt("amount"), rs.getString("time"), rs.getInt("noOfItems"));
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
			PreparedStatement ps = DbConnection.getConnection().prepareStatement("select * from order");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				orderList.add(new Order(rs.getInt("orderId"), rs.getInt("amount"), rs.getString("time"), rs.getInt("noOfItems")));
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orderList;
	}

	public void addOrder(Order order) {
		try {
			String query = "insert into order(orderId, amount, time, noOfItems)" + "values(?,?,?,?)";
			PreparedStatement ps = DbConnection.getConnection().prepareStatement(query);
			ps.setInt(1, order.getOrderId());
			ps.setInt(2, order.getAmount());
			ps.setString(3, order.getTime());
			ps.setInt(4, order.getNoOfItems());
			ps.executeQuery();
			ps.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void removeOrder(int orderId) {
		try {
			PreparedStatement ps = DbConnection.getConnection().prepareStatement("select * from order where orderId=" + orderId);
			ResultSet rs = ps.executeQuery();
			if(rs.first()) {
				PreparedStatement ps1 = DbConnection.getConnection().prepareStatement("delete * from order where orederId=" + orderId);
				ps1.executeQuery();
			} else {
				System.out.println("Order did't exist, hence can't delete!");
			}
			ps.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
