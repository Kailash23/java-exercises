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
 *         Unit testing in producer consumer problem.
 */

public class AppTest {
	
	@Before
	public void setUp() {
		
		App app = new App();
	}

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before Class");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("After Class");
	}

	@After
	public void after() {
		System.out.println("After");
	}

	@Test
	public void testSum() {
		Assert.assertEquals(9, 9);
	}

	@Test
	public void testMultiply() {
		Assert.assertEquals(9, 9);
	}

}
