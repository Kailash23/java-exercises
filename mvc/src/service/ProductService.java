package service;

import java.util.List;

import dao.ProductDao;
import model.Product;

/**
 * @author kailash23 
 * 
 * 1 - Deals with 'product' table.
 * 2 - Display all products - fetch from product.
 * 3 - Rearrange based on price and then display.
 * 4 - Should contain methods for changing product details.
 * 5 - Will render menu in form of table.
 * 
 * getItemList(orderId) - Retrieve item list based on orderId.
 * addProduct()
 * removeProduct()
 * editProduct()
 * 
 */

public class ProductService {

	private ProductDao productDao;

	public ProductDao getProductDao() {
		return productDao;
	}
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}
	
	public Product getProductById(String productId) {
		return productDao.getProductById(productId);
	}
	
	public void deleteProduct(String productId) {
		productDao.deleteProduct(productId);
	}
	
	public void editProduct(Product product){
		productDao.editProduct(product);
	}
}
