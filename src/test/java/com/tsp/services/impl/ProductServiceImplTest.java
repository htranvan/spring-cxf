package com.tsp.services.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.tsp.dao.ProductDao;
import com.tsp.model.Product;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

	@InjectMocks
	private ProductServiceImpl productSrvImpl;
	
	@Mock
	private ProductDao productDao;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetProduct() {
		Product p = new Product();
		p.setId("12345");
		p.setName("MacBook Air");
		p.setType("Electronics");
		Mockito.when(productDao.getProduct("12345")).thenReturn(p);
		assertTrue(productSrvImpl.getProduct("12345").getId().equals(p.getId()));
	}

	@Test
	public void testSaveProduct() {
		Product p = new Product();
		p.setId("45677");
		p.setName("MacBook Pro");
		p.setType("Electronics");
		Mockito.when(productDao.saveProduct(p)).thenReturn(p.getId());
		assertEquals(p.getId(), productSrvImpl.saveProduct(p));
	}

}
