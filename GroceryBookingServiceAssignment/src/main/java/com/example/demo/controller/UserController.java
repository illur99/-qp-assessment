package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.GroceryNotFoundException;
import com.example.demo.model.Grocery;
import com.example.demo.model.User;
import com.example.demo.service.GroceryService;
import com.example.demo.service.UserService;

import jakarta.persistence.Entity;

@RestController
public class UserController {
	@Autowired
	private GroceryService gservice;

	@Autowired
	private UserService service;

	@GetMapping("/getAllGrocery")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<List<Grocery>> viewItems() throws GroceryNotFoundException {
		List<Grocery> result = gservice.getAllGrocery();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PostMapping("/addUser")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<String> placeOrder(@RequestBody User user) {
		String result = service.bookOrder(user);
		return new ResponseEntity<>(result, HttpStatus.CREATED);

	}

}
