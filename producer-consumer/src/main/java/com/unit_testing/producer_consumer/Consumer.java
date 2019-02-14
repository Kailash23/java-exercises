package com.unit_testing.producer_consumer;

public class Consumer implements Runnable {

	QueueResource queueResource;
	int delay;
	Boolean wait = true;

	void halt() {
		Thread t = new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(15 /*seconds*/ * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				wait = false;
			}
		});
		t.start();
	}

	public Consumer(QueueResource queue, int delay) {
		this.queueResource = queue;
		this.delay = delay;
	}

	public void consume() {
		halt();
		queueResource.takeFromQueue();
	}

	public void run() {
		while (wait) {
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			consume();
		}
	}

}
