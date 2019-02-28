package com.mvc.utils;

import java.util.UUID;

public class Utils {
	
	public static int generateProductId() {
		String uniqueID = UUID.randomUUID().toString();
		int id = 0;
		for (int i = 0; i < uniqueID.length(); i++) {
			id += uniqueID.charAt(i);
		}
		return id;
	}
	
	public static int generateOrderId() {
		String uniqueID = UUID.randomUUID().toString();
		int id = 0;
		for (int i = 0; i < uniqueID.length(); i++) {
			id += uniqueID.charAt(i);
		}
		return id;
	}
}
