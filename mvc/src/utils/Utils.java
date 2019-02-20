package utils;

import java.util.UUID;

/**
 * 
 * @author kailash23
 *
 * Generate product id - UUID to ASCII sum.
 * Generate order id - - UUID to ASCII sum
 * 
 */
public class Utils {
	
	public int generateProductId() {
		String uniqueID = UUID.randomUUID().toString();
		int id = 0;
		for (int i = 0; i < uniqueID.length(); i++) {
			id += uniqueID.charAt(i);
		}
		return id;
	}
	
	public int generateOrderId() {
		String uniqueID = UUID.randomUUID().toString();
		int id = 0;
		for (int i = 0; i < uniqueID.length(); i++) {
			id += uniqueID.charAt(i);
		}
		return id;
	}
}
