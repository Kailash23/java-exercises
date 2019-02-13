package org;

import java.util.Random;

public class Utils {
	
	static Random rand = new Random();
	
	public static long generateEmpId(String name) {
		long var = 0;
		for(int i = 0; i < name.length(); i++) {
			var += name.charAt(i);
		}
		return var;
	}
}
