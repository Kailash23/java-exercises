package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Order;
import model.Product;

/**
 * 
 * @author kailash23
 *
 *         getAllProducts() - Contains method for fetching all product to
 *         display on menu and send list to menu to render. param - menu will
 *         provide based on what list to be sorted. based on - category, date
 * 
 * 
 */
public class ProductDao {

	private List<Product> productList = new ArrayList<>();
	
	public void addProduct(Product product) {

	}
	
	public void editProduct(Product product) {
		
	}

	public List<Product> getProductList() {
		
		try {
			PreparedStatement ps = DbConnection.getConnection().prepareStatement("select * from product");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				productList.add(new Product(rs.getInt("productId"), rs.getString("productName"), rs.getInt("price"), rs.getString("desc"), rs.getInt("category")));
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return productList;
	}
		
	
	public Product getProductById(int productId) {
		Product product = null;
		return product;
	}

	public void deleteProduct(int productId) {

	}

}
