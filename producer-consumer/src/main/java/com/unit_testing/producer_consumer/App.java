package com.unit_testing.producer_consumer;

public class App {
	
	static QueueResource queue = new QueueResource(6);
	
	public static void main(String[] args) {
		startProducer(1000);
		startConsumer(2000);
	}
	
	public static void startProducer(int delay) {
		Producer producer = new Producer(queue, delay);
		Thread producerThread = new Thread(producer);
		producerThread.setName("producer");
		producerThread.start();
	}
	
	public static void startConsumer(int delay) {
		Consumer consumer = new Consumer(queue, delay);
		Thread consumerThread = new Thread(consumer);
		consumerThread.setName("consumer");
		consumerThread.start();
	}
	
	public int getQueueSize() {
		return queue.getSize();
	}
}
