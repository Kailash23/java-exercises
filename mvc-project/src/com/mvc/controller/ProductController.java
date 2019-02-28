package com.mvc.controller;


import java.util.List;

import com.mvc.model.Product;
import com.mvc.service.ProductService;



public class ProductController {

	private ProductService productService = new ProductService();

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public List<Product> getProductList() {
		List<Product> products = productService.getProductList();
		return products;
	}
	
	public Product getProductById(int productId) {
		Product product = productService.getProductById(productId);
		return product;
	}
	
	public Product getProductByName(String name) {
		Product product = productService.getProductByName(name);
		return product;
	}

	public void deleteProduct(int productId) {
		productService.deleteProduct(productId);
	}
	
	public void addProduct(Product product){
		productService.addProduct(product);
	}
}
