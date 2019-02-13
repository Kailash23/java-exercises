package com.unit_testing.producer_consumer;

import org.junit.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import org.junit.Test;

/**
 * 
 * @author kailash23
 *
 * Unit testing in producer consumer problem.
 */

public class AppTest {

	static int numOfTestCases;
	static int consumerThreadSleepTime;
	static int producerThreadSleepTime;

	@BeforeClass
	public static void AppInitialized() {
		numOfTestCases = 0;
		consumerThreadSleepTime = 1000;
		producerThreadSleepTime = 2000;
	}

	@Before
	public void changingParameters() {
		numOfTestCases++;
		App.startConsumer(consumerThreadSleepTime);
		App.startProducer(producerThreadSleepTime);
	}

	public Thread[] getThreadList() {
		ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
		int threadCount = threadGroup.activeCount();
		Thread[] list = new Thread[threadCount];
		threadGroup.enumerate(list);
		return list;
	}

	public Boolean checkThreadPresence(String name) {
		Boolean bool = false;

		Thread[] list = getThreadList();
		int threadCount = list.length;

		for (int i = 0; i < threadCount; i++) {
			if (list[i].getName() == name) {
				bool = true;
			}
		}
		return bool;
	}

	/**
	 * Test 1 : Checks whether consumer thread running or not.
	 */
	@Test
	public void checkConsumerThreadRunning() {

		System.out.print("Test " + numOfTestCases + ": ");

		Boolean bool = checkThreadPresence("consumer");
		Assert.assertEquals(bool, true);

		if (bool == true) {
			System.out.println("Consumer thread running ...!");
		} else {
			System.out.println("Consumer thread not running ...!");
		}
	}

	/**
	 * Test 2 : Checks whether producer thread running or not.
	 */
	@Test
	public void checkProducerThreadRunning() {

		System.out.print("Test " + numOfTestCases + ": ");

		Boolean bool = checkThreadPresence("producer");
		Assert.assertEquals(bool, true);

		if (bool == true) {
			System.out.println("Producer thread running ...!");
		} else {
			System.out.println("Producer thread not running ...!");
		}
	}

	/**
	 * Test 3 :
	 */
	@Test
	public void test4() throws InterruptedException {
		System.out.print("Test " + numOfTestCases + ": ");
		
		Thread t = new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(5 /*seconds*/ * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t.start();
		
		if(consumerThreadSleepTime > producerThreadSleepTime) {
			System.out.println(App.queue.getSize());
		} else if(consumerThreadSleepTime <  producerThreadSleepTime){
			System.out.println(App.queue.getSize());
		} else {
			System.out.println(App.queue.getSize());
		}
		
	}

	/**
	 * Test 5 :
	 */
	@Test
	public void test5() {

	}

	@After
	public void after() {

	}

	@AfterClass
	public static void afterClass() {

	}

}
