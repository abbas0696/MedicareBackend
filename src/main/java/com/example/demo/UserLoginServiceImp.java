package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImp implements UserLoginService{
	
	@Autowired
	UserLoginRepository repo;
	
	public UserLogin saveUserLogin(UserLogin u) {
		return repo.save(u);
	}
	
	public List<UserLogin> getAllUserLogin(){
		return repo.findAll();
	}

}
