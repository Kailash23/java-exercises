package com.unit_testing.producer_consumer;

public class Producer implements Runnable {

	QueueResource queueResource;
	
	int val = 0; 
	
	public Producer(QueueResource queue) {
		this.queueResource = queue;
	}
	
	public void produce() {
		queueResource.putInQueue(val++);
	}
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			produce();
		}
	}

}
