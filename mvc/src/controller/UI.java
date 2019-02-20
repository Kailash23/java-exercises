package controller;

import java.util.Scanner;

/**
 * 
 * @author kailash23
 *
 *         Administrator (1 admin) - Change product details - Have access to DB
 * 
 *         User - Can buy products (1 user) - Can check for products they bought
 *         earlier based on order id - Can see menu and arrange data based on
 *         price. - No login - Can add items to cart for ordering. - (Menu)
 *         After adding to cart -> order window
 */
public class UI {

	private static void menuOptions() {
		System.out.println("");
		System.out.println("1 - Arrange by name");
		System.out.println("2 - Arrange by date");
		System.out.println("");
	}

	private static void modeOptions() {
		System.out.println("");
		System.out.println("1 - User");
		System.out.println("2 - Admin");
		System.out.println("3 - Exit");
		System.out.println("");
	}

	private static void userOptions() {
		System.out.println("");
		System.out.println("1 - Check menu");
		System.out.println("2 - Find product by name");
		System.out.println("3 - Find product by product id");
		System.out.println("4 - Check previous orders");
		System.out.println("5 - Exit");
		System.out.println("");
	}

	private static void adminOptions() {
		System.out.println("");
		System.out.println("1 - Add product");
		System.out.println("2 - Find product by name");
		System.out.println("3 - Find product by product id");
		System.out.println("4 - Show all products");
		System.out.println("5 - Show all users");
		System.out.println("5 - Show all orders");
		System.out.println("6 - Exit");
		System.out.println("");
	}

	public static void main(String[] args) {

		// Establish DB connection here
		
		modeOptions();
		Scanner in = new Scanner(System.in);
		int choice = Integer.parseInt(in.next());

		switch (choice) {

			case 1: // User
				userOptions();
				
				int ch1 = Integer.parseInt(in.next());
				
				switch (ch1) {
				
					case 1:	
						break;
						
					case 2:
						break;
						
					case 3:
						break;
						
					case 4:
						break;
						
					case 5:
						break;
						
				}
				break;

			case 2: // Admin
				adminOptions();
				
				int ch2 = Integer.parseInt(in.next());
				
				switch (ch2) {
				
					case 1:	
						break;
						
					case 2:
						break;
						
					case 3:
						break;
						
					case 4:
						break;
						
					case 5:
						break;
						
				}
				break;

			case 3:
				
		}
		in.close();

	}
}
