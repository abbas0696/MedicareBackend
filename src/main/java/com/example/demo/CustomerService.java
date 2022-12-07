package com.example.demo;

import java.util.List;

public interface CustomerService {
	
	public Customer saveCustomer(Customer c);
	public Customer updateCustomer(Customer c, int id);
	public boolean deleteCustomer(int id);
	public Customer getCustById(int id);
	public List<Customer> getAllCustomer();
	
	
	

}
