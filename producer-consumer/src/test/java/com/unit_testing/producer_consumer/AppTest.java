package com.unit_testing.producer_consumer;

import org.junit.Assert;

import org.junit.Before;
import org.junit.BeforeClass;

import org.junit.Test;

/**
 * 
 * @author kailash23
 *
 * Unit testing in producer-consumer problem.
 */

public class AppTest {

static int numOfTestCases;
private	static int consumerThreadSleepTime;
private static int producerThreadSleepTime;

	@BeforeClass
	public static void appStart() {
		numOfTestCases = 0;
		consumerThreadSleepTime = 2000;
		producerThreadSleepTime = 2000;
		App.startConsumer(consumerThreadSleepTime);
		App.startProducer(producerThreadSleepTime);
	}

	@Before
	public void beforeTest() {
		numOfTestCases++;
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
		Boolean bool = checkThreadPresence("consumer");
		Assert.assertEquals(bool, true);
	}

	/**
	 * Test 2 : Checks whether producer thread running or not.
	 */
	@Test
	public void checkProducerThreadRunning() {
		Boolean bool = checkThreadPresence("producer");
		Assert.assertEquals(bool, true);
	}

	/**
	 * Test 3 : Checking putInQueue() function of QueueResource
	 */
	@Test
	public void checkProducer() throws InterruptedException {

		int queueSize = 5;
		QueueResource queueResource = new QueueResource(queueSize);
		// Producing first item - 5
		queueResource.putInQueue(5);

		// element is present in queue's front
		int element = queueResource.queue.element();
		
		// Only element at queue ie 5
		Assert.assertEquals(element, 5);
	}

	/**
	 * Test 4 : Checking takeFromQueue() function of QueueResource
	 */
	@Test
	public void checkConsumer() {
		
		int queueSize = 5;
		QueueResource queueResource = new QueueResource(queueSize);
		// First item produced - 1
		queueResource.putInQueue(1);
		// Second item produced - 2
		queueResource.putInQueue(2);
		
		// Queue should be like >1>2, consumer will consume form front
		// Queue after consuming one time >2
		
		queueResource.takeFromQueue();
		
		int queueFront = queueResource.queue.element();
		
		// Queue front should be 2
		Assert.assertEquals(queueFront, 2);
		// Queue size should be 1
		Assert.assertEquals(queueResource.queue.size(), 1);
	}
}
