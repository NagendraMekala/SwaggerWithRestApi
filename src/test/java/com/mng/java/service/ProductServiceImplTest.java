package com.mng.java.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.mng.java.model.Product;

@RunWith(SpringRunner.class)
@EnableAutoConfiguration
public class ProductServiceImplTest {
	
	//@Autowired
	ProductService productService;

	@Before
	public void setUp() {
		productService = new ProductServiceImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() {
	}
	
	@Test
	public void testList() {
		productService.setProducts(getProductList());
		List<Product> productsList = productService.listAllProducts();
		assertNotNull(productsList);
		assertTrue(productsList.size() > 0);
	}
	
	@Test
	public void testFetProductById() {
		productService.setProducts(getProductList());
		Product product = productService.getProductById(001);
		assertNotNull(product);
		assertTrue(product.getId() == 001);
		assertEquals("mock laptop", product.getProductId());
		assertEquals("mock product configuration info", product.getDescription());
		assertEquals("mock://localhost:8080/delImage", product.getImageUrl());
		assertTrue(product.getPrice() == 50000);
		assertTrue(product.getVersion() == 5);
		
	}
	
	@Test
	public void testSaveProduct() {
		Product p1 = new Product();
		p1.setId(3);
		p1.setProductId("laptop");
		p1.setDescription("product configuration info");
		p1.setImageUrl("mock://localhost:8080/delImage");
		p1.setPrice(50000);
		p1.setVersion(5);
		
		productService.saveProduct(3, p1);
		
		Product product = productService.getProductById(3);
		assertNotNull(product);
		assertTrue(product.getId() == 3);
		assertEquals("laptop", product.getProductId());
		assertEquals("product configuration info", product.getDescription());
	}
	
	@Test
	public void testDeleteProduct() {
		productService.deleteProduct(001);
		assertFalse(productService.exists(001));
	   }
	
	@Test
	public void testGetProductList() {
		assertTrue(productService.getProductList().size() > 0);
	   }
	
	public Map<Integer, Product> getProductList() {
		Map<Integer,Product> products = new HashMap<>();
		Product p1 = new Product();
		p1.setId(001);
		p1.setProductId("mock laptop");
		p1.setDescription("mock product configuration info");
		p1.setImageUrl("mock://localhost:8080/delImage");
		p1.setPrice(50000);
		p1.setVersion(5);

		Product p2 = new Product();
		p2.setId(002);
		p2.setProductId("mock laptop");
		p2.setDescription("mock product configuration info");
		p2.setImageUrl("http://localhost:8080/lenovoImage");
		p2.setPrice(40000);
		p2.setVersion(4);
         
		products.put(001, p1);
		products.put(002, p2);
	  return products;
	}
	}

