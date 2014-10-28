package com.tsp.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tsp.model.Product;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-hibernate.xml", "classpath:applicationContext.xml"})
public class ProductDaoImplTest {

	@Autowired
	private ProductDao productDao;
	
	@Test
	public void testGetProduct() {
		Product p = new Product();
		p.setId("78945");
		p.setName("Apple Laptop");
		p.setType("Electronics");
		productDao.saveProduct(p);
		assertTrue(p.equals(productDao.getProduct("78945")));
	}

	@Test
	public void testSaveProduct() {
		Product p1 = new Product();
		p1.setId("45678");
		p1.setName("Apple Iphone");
		p1.setType("Electronics");
		String id = productDao.saveProduct(p1);
		assertEquals(String.valueOf(id), String.valueOf("5566"));
	}

}
