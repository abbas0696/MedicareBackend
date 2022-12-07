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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping("")
	public ResponseEntity<Object> saveProduct(@RequestBody Product prod){
		Product repo = service.saveProduct(prod);
		if(repo!=null) {
			return new ResponseEntity<>(repo, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("no Product found", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("")
	public List<Product> getAll(){
		return service.getAllProduct();
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable int id){
		if(service.deleteProduct(id)) {
			return new ResponseEntity<>("deleted Successfully", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("no Product to delete", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Object> getProdById(@PathVariable int id){
		Product repo = service.getProdById(id);
		if(repo!=null) {
			return new ResponseEntity<>(repo, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("not Product to update", HttpStatus.NOT_FOUND);
		}
	}

}
