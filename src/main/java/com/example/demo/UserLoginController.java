package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/userLogin")
public class UserLoginController {
	
	@Autowired
	private UserLoginService service;
	
	@PostMapping("")
	public ResponseEntity<Object> saveUserLogin(@RequestBody UserLogin login){
		UserLogin repo= service.saveUserLogin(login);
		if(repo!=null) {
			return new ResponseEntity<>(repo, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("no User Available", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("")
	public List<UserLogin> getAllUserLogin(){
		return service.getAllUserLogin();
	}
	

}
