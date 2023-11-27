package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repo.userRepo;

@Service
public class UserService {
	@Autowired
	private userRepo repo;

	public String bookOrder(User user) {
		// TODO Auto-generated method stub
		repo.save(user);
		return "Order placed successfully for user with userId "+user.getUserId();
		
	}


}
