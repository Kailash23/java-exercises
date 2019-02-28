package com.mvc.service;

import java.util.List;

import com.mvc.dao.ProductDao;
import com.mvc.model.Product;


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

	private ProductDao productDao = new ProductDao();

	public ProductDao getProductDao() {
		return productDao;
	}
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	public List<Product> getProductList() {
		return productDao.getProductList();
	}
	
	public Product getProductById(int productId) {
		return productDao.getProductById(productId);
	}
	
	public Product getProductByName(String name) {
		return productDao.getProductByName(name);
	}
	
	public void deleteProduct(int productId) {
		productDao.deleteProduct(productId);
	}
	
	public void addProduct(Product product) {
		productDao.addProduct(product);
	}
	
//	TODO : edit product
}