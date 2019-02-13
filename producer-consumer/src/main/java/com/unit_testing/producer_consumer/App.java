package com.unit_testing.producer_consumer;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		QueueResource queue = new QueueResource(5);
		
		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);
		
		Thread producerThread = new Thread(producer);
		Thread consumerThread = new Thread(consumer);
		
		producerThread.start();
		consumerThread.start();
	}
}
