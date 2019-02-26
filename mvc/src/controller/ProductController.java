package controller;

import java.util.List;

import model.Product;
import service.ProductService;

public class ProductController {

	private ProductService productService;

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public List<Product> getAllProducts() {
		List<Product> products = productService.getAllProducts();
		return products;
	}
	
	public Product viewProduct(String productId) {
		Product product = productService.getProductById(productId);
		return product;
	}

	public void deleteProduct(String productId) {
		productService.deleteProduct(productId);
	}
	
	public void addProduct() {
//		productService.addProduct(new Product());
	}
}
