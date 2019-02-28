package com.mvc.view;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import com.mvc.controller.OrderController;
import com.mvc.controller.ProductController;
import com.mvc.dao.DbConnection;
import com.mvc.model.Order;
import com.mvc.model.Product;
import com.mvc.utils.Utils;

public class Main {

	private static List<Product> cartList = new ArrayList<>();

	private static Connection connection;

	private static void userOptions() {
		System.out.println("");
		System.out.println("1 - Show menu");
		System.out.println("2 - Find product by name");
		System.out.println("3 - Find product by product ID");
		System.out.println("4 - Add product to cart using product ID");
		System.out.println("5 - Show cart");
		System.out.println("6 - Order Now");
	}

	private static void adminOptions() {
		System.out.println("");
		System.out.println("7 - Add new product to DB");
		System.out.println("8 - Show all orders");
		System.out.println("9 - Show order by ID");
		System.out.println("10 - Exit");
	}

	private static void options() {
		// TODO : user mode & admin mode
		userOptions();
		adminOptions();
	}

	public static void main(String[] args) {
		connection = DbConnection.getConnection();

		ProductController productController = new ProductController();
		OrderController orderController = new OrderController();

		options();

		Scanner in = new Scanner(System.in);
		int choice = Integer.parseInt(in.next());

		Product product;
		int id;

		while (choice != 10) {

			switch (choice) {

			case 1:
				List<Product> productList = productController.getProductList();

				System.out.println("-------------------------------Products-----------------------------");
				System.out.printf("%10s %10s %13s %10s %10s", "id", "name", "price", "desc", "category");
				System.out.println();
				System.out.println("--------------------------------------------------------------------");

				for (Product item : productList) {
					System.out.format("%10d %10s %10d %15s %10d", item.getProductId(), item.getProductName(),
							item.getPrice(), item.getDesc(), item.getCategory());
					System.out.println();
				}
				break;

			case 2:
				System.out.println("Enter product's name which you want to search. ");
				String name = in.next();
				product = productController.getProductByName(name);

				System.out.println("--------------------------------------------------------------------");
				System.out.printf("%10s %10s %13s %10s %10s", "id", "name", "price", "desc", "category");
				System.out.println();
				System.out.println("--------------------------------------------------------------------");
				System.out.format("%10d %10s %10d %15s %10d", product.getProductId(), product.getProductName(),
						product.getPrice(), product.getDesc(), product.getCategory());
				System.out.println();
				break;

			case 3:
				System.out.println("Enter product's id which you want to search. ");
				id = in.nextInt();
				product = productController.getProductById(id);

				System.out.println("--------------------------------------------------------------------");
				System.out.printf("%10s %10s %13s %10s %10s", "id", "name", "price", "desc", "category");
				System.out.println();
				System.out.println("--------------------------------------------------------------------");
				System.out.format("%10d %10s %10d %15s %10d", product.getProductId(), product.getProductName(),
						product.getPrice(), product.getDesc(), product.getCategory());
				System.out.println();
				break;

			case 4:
				System.out.println("Enter product's id to add product to cart");
				id = in.nextInt();
				product = productController.getProductById(id);
				cartList.add(product);
				break;

			case 5:
				System.out.println("----------------------------------Cart-----------------------------");
				System.out.printf("%10s %10s %13s %10s %10s", "id", "name", "price", "desc", "category");
				System.out.println();
				System.out.println("--------------------------------------------------------------------");

				for (Product item : cartList) {
					System.out.format("%10d %10s %10d %15s %10d", item.getProductId(), item.getProductName(),
							item.getPrice(), item.getDesc(), item.getCategory());
					System.out.println();
				}
				break;

			case 6:
				orderController.placeOrder(cartList);
				System.out.println("Order placed !");
				break;

			case 7:
				int prodId = Utils.generateProductId();
				System.out.println("Enter Product's Name : ");
				String prodName = in.next();
				System.out.println("Enter Product's Price : ");
				int price = in.nextInt();
				System.out.println("Enter Product's Desc : ");
				String desc = in.next();
				System.out.println("Enter Product's Category : ");
				int category = in.nextInt();

				Product newProduct = new Product(prodId, prodName, price, desc, category);
				productController.addProduct(newProduct);
				break;

			case 8:
				List<Order> orderList = orderController.viewOrders();

				System.out.println("-------------------------------Orders-----------------------------");
				System.out.printf("%10s %10s %17s %10s", "orderId", "amount", "time", "noOfItems");
				System.out.println();
				System.out.println("--------------------------------------------------------------------");

				for (Order item : orderList) {
					System.out.format("%10d %10d %17s %15d", item.getOrderId(), item.getAmount(), item.getTime(),
							item.getNoOfItems());
					System.out.println();
				}
				break;

			case 9:
				System.out.println("Enter order id for the details");
				id = in.nextInt();
				Order order = orderController.getOrderById(id);
				
				System.out.println("-------------------------------Orders-----------------------------");
				System.out.printf("%10s %10s %17s %10s", "orderId", "amount", "time", "noOfItems");
				System.out.println();
				System.out.println("--------------------------------------------------------------------");

				System.out.format("%10d %10d %17s %10d", order.getOrderId(), order.getAmount(), order.getTime(),
						order.getNoOfItems());
				System.out.println();
				break;

			default:

				break;
			}

			options();

			choice = Integer.parseInt(in.next());

		}

	}

}
