package com.tsp.dao;

import org.springframework.stereotype.Repository;

import com.tsp.model.Product;

@Repository("productDao")
public class ProductDaoImpl extends GeneralDao<Product, String> implements ProductDao {

	
	public Product getProduct(String id) {
		// Create some fake product and return
//		Product product = new Product();
//		product.setId(id);
//		product.setName("MAC Book Air");
//		product.setType("Electronics");
		return this.get(id);
	}

	public String saveProduct(Product product) {
		String id = this.save(product);
		return id;
	}
	
	

}
