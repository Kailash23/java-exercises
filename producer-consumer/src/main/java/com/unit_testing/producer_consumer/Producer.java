package com.unit_testing.producer_consumer;

public class Producer implements Runnable {

	QueueResource queueResource;
	int delay;
	Boolean bool = true;
	
	int val = 0; 
	
	void halt() {
		Thread t = new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(15 /*seconds*/ * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				bool = false;
			}
		});
		t.start();
	}
	
	public Producer(QueueResource queue, int delay) {
		this.queueResource = queue;
		this.delay = delay;
	}
	
	public void produce() {
		queueResource.putInQueue(val++);
	}
	
	public void run() {
		while(bool) {
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			produce();
		}
	}

}
