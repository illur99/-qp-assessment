package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.GroceryNotFoundException;
import com.example.demo.model.Grocery;
import com.example.demo.service.GroceryService;

@RestController
public class GroceryController {
	@Autowired
	private GroceryService service;

	@PostMapping("/add")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<String> addGrocery(@RequestBody Grocery grocery) {
		String result = service.addGrocery(grocery);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<List<Grocery>> viewAllGrocery() throws GroceryNotFoundException {
		List<Grocery> result = service.getAllGrocery();
		return new ResponseEntity<>(result, HttpStatus.OK);

	}

	@PutMapping("/update/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<String> updateGrocery(@RequestBody Grocery grocery, @PathVariable(required = true) int id)
			throws GroceryNotFoundException {

		String result = service.updateGrocery(grocery, id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<String> removeGrocery(@PathVariable int id) throws GroceryNotFoundException {
		String result = service.remove(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("/test")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<String> test()
	{
		return ResponseEntity.ok("testing");
	}

}
