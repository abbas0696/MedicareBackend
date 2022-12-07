package com.example.demo;

import java.util.List;

public interface ProductService {
	
	public Product saveProduct(Product p);
	public List<Product> getAllProduct();
	public boolean deleteProduct(int id);
	public Product getProdById(int id);

}
