package com.tsp.dao;

import com.tsp.model.Product;

public interface ProductDao{

	
	public Product getProduct(String id);

	public String saveProduct(Product product);
}
