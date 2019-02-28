package com.mvc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.model.Product;


public class ProductDao {

	private List<Product> productList = new ArrayList<>();

	public void addProduct(Product product) {
		try {

			int prodId = product.getProductId();
			String prodName = product.getProductName();
			int price =  product.getPrice();
			String desc =  product.getDesc();
			int category = product.getCategory();
			
			String query = "INSERT INTO product VALUES ('" + prodId + "','" + prodName
					+ "', '" + price + "', '" + desc + "', '" + category + "');";
			PreparedStatement ps = DbConnection.getConnection().prepareStatement(query);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Product> getProductList() {

		try {
			PreparedStatement ps = DbConnection.getConnection().prepareStatement("select * from product");
			ResultSet rs = ps.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				productList.add(new Product(rs.getInt("productId"), rs.getString("productName"), rs.getInt("price"),
						rs.getString("desc"), rs.getInt("category")));
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return productList;
	}

	public Product getProductById(int productId) {
		Product product = null;
		try {
			PreparedStatement ps = DbConnection.getConnection()
					.prepareStatement("select * from product where productId=" + productId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				product = new Product(rs.getInt("productId"), rs.getString("productName"), rs.getInt("price"),
						rs.getString("desc"), rs.getInt("category"));
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}
	
	public Product getProductByName(String name) {
		Product product = null;
		try {
			PreparedStatement ps = DbConnection.getConnection()
					.prepareStatement("select * from product where productName='" + name +"'");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				product = new Product(rs.getInt("productId"), rs.getString("productName"), rs.getInt("price"),
						rs.getString("desc"), rs.getInt("category"));
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	public void deleteProduct(int productId) {
		try {
			PreparedStatement ps = DbConnection.getConnection()
					.prepareStatement("delete * from product where id=" + productId);
			ps.executeQuery();

			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
