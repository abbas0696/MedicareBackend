package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Customer/Product")
public class OrderController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@PostMapping
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);	
	}
	
	@GetMapping
	public List<Customer> getAll(){
		return customerRepository.findAll();
	}
	
	@GetMapping("{id}")
	public Customer findCust(@PathVariable int id) {
		return customerRepository.findById(id).get();				
	}
	
	@GetMapping("/find{name}")
	public List<Customer> findByNameContaining(@PathVariable String name){
		return customerRepository.findByNameContaining(name);
	}

	@GetMapping("/find{id}")
	public List<Product> findById(@PathVariable int id){
		return productRepository.findById(id);
	}
}
