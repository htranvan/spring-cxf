package com.tsp.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tsp.model.Product;
import com.tsp.services.ProductService;

@Component("productService")
public class ProductWSImpl implements ProductWS {
	
	@Autowired
	private ProductService productService;


	public Product getProduct(  String id) {
		System.out.println("product id=" + id);
		return productService.getProduct(id);
	}


	public String saveProduct() {
		Product product = new Product();
		product.setId("456789");
		product.setName("MAC Book Air");
		product.setType("Electronics");
		return productService.saveProduct(product);
	}

}
