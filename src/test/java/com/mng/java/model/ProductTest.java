package com.mng.java.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class ProductTest {
	
	@Before
	public void setUp() {
	}

	@AfterClass
	public static void tearDownAfterClass() {
	}
	
	@Test
	public void testProduct() {
		Product p1 = new Product();
		p1.setId(001);
		p1.setProductId("mock laptop");
		p1.setDescription("mock product configuration info");
		p1.setImageUrl("mock://localhost:8080/delImage");
		p1.setPrice(50000);
		p1.setVersion(5);
		
		assertEquals("mock laptop", p1.getProductId());
		assertEquals("mock product configuration info", p1.getDescription());
		assertEquals("mock://localhost:8080/delImage", p1.getImageUrl());
		assertTrue(p1.getPrice() == 50000);
		assertTrue(p1.getVersion() == 5);
	}
	

}
