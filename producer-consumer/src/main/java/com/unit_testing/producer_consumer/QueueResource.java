package com.unit_testing.producer_consumer;

import java.util.LinkedList;
import java.util.Queue;

public class QueueResource {

	Queue<Integer> queue = new LinkedList<Integer>();
	public int queueSize;
	
	QueueResource(int size) {
		this.queueSize = size;
	}
	
	public synchronized void putInQueue(int num) {
		Utils.print(queue);
		if(queue.size() == queueSize) {
			System.out.println("Producer waiting ... !");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Adding to queue : "  + num);
			queue.add(num);
			notify();
		}
	}
	
	public synchronized void takeFromQueue() {
		Utils.print(queue);
		if(queue.size() == 0) {
			System.out.println("Consumer waiting ... !");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Consuming ...");
			queue.remove();
			notify();
		}
	}
	
}
