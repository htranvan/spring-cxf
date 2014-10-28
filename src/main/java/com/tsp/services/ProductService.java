package com.tsp.services;

import com.tsp.model.Product;

public interface ProductService {

	public Product getProduct(String id);

	public String saveProduct(Product product);

}
