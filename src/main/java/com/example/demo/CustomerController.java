package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@PostMapping("")
	public ResponseEntity<Object> saveCustomer(@RequestBody Customer cust){
		Customer repo = service.saveCustomer(cust);
		if(repo!=null) {
			return new ResponseEntity<>(repo, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("no Custoemr Found", HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("{id}")
	public ResponseEntity<Object> updateCustomer(@RequestBody Customer c, @PathVariable int id){
		Customer repo = service.updateCustomer(c, id);
		if(repo!=null) {
			return new ResponseEntity<>(repo, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("no Customer to update", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("")
	public List<Customer> getAll(){
		return service.getAllCustomer();
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Object> deleteCutomer(@PathVariable int id){
		if(service.deleteCustomer(id)) {
			return new ResponseEntity<>("deleted successfully", HttpStatus.FOUND);
		}
		else {
			return new ResponseEntity<>("no Customer to delete", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Object> getById(@PathVariable int id){
		Customer repo = service.getCustById(id);
		if(repo!=null) {
			return new ResponseEntity<>(repo, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("no Customer to update", HttpStatus.NOT_FOUND);
		}
	}

}
