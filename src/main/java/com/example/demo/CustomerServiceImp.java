package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImp implements CustomerService {
	
	@Autowired
	CustomerRepository repo;
	
	public Customer saveCustomer(Customer c) {
		return repo.save(c);
	}
	public Customer updateCustomer(Customer newData, int id) {
		if(repo.findById(id).isPresent()) {
			Customer oldData = repo.findById(id).get();
			oldData.setName(newData.getName());
			oldData.setEmail(newData.getEmail());
			oldData.setAddress(newData.getAddress());
			return repo.save(oldData);
	}
		else {
			return null;
		}
	}
	
	public List<Customer> getAllCustomer() {
		return repo.findAll();
	}	
		
	public boolean deleteCustomer(int id) {
		if(repo.findById(id).isPresent()) {
			repo.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}
	
	public Customer getCustById(int id) {
		if(repo.findById(id).isPresent()) {
			return repo.findById(id).get();
		}
		else {
			return null;
		}
	}
}

