package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImp implements ProductService{
	
	@Autowired
	ProductRepository repo;
	
	public Product saveProduct(Product p) {
		return repo.save(p);
	}
	
	public List<Product> getAllProduct(){
		return repo.findAll();
	}
	
	public boolean deleteProduct(int id) {
		if(repo.findById(id).isPresent()) {
			repo.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}
	public Product getProdById(int id) {
		if(repo.findById(id).isPresent()) {
			return repo.findById(id).get();
		}
		else {
			return null;
		}
	}

}
