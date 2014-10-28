package com.tsp.services.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tsp.dao.ProductDao;
import com.tsp.model.Product;
import com.tsp.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	@Qualifier("productDao")
	private ProductDao prodcutDao;
	
	@Transactional
	public Product getProduct(String id) {
		System.out.println("product id="+id);
		return prodcutDao.getProduct(id);
	}
	
	@Transactional
	public String saveProduct(Product product) {
		return prodcutDao.saveProduct(product);
		
	}

}
