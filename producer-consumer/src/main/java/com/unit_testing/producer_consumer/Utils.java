package com.unit_testing.producer_consumer;

import java.util.*;

public class Utils {

	static void print(Queue<Integer> queue) {
		for(Integer item : queue) {
			System.out.println(item);
		}
	}
}
