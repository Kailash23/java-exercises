package com.unit_testing.producer_consumer;

public class Consumer implements Runnable {

	QueueResource queueResource;
	
	public Consumer(QueueResource queue) {
		this.queueResource = queue;
	}
	
	public void consume() {
		queueResource.takeFromQueue();
	}
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			consume();
		}
	}

}
