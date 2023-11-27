package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.GroceryNotFoundException;
import com.example.demo.model.Grocery;
import com.example.demo.repo.GroceryRepo;

@Service
public class GroceryService {
	@Autowired
	private GroceryRepo repo;

	public String addGrocery(Grocery grocery) {
		// TODO Auto-generated method stub
		repo.save(grocery);
		return "Grocery with id " + grocery.getGroceryId() + " is added successfully";

	}

	public List<Grocery> getAllGrocery() throws GroceryNotFoundException {
		// TODO Auto-generated method stub
		List<Grocery> result = repo.findAll();
		if (result.isEmpty()) {
			throw new GroceryNotFoundException("Grocery items does not exists");
		} else
			return result;
	}

	public String remove(int id) throws GroceryNotFoundException {
		// TODO Auto-generated method stub
		repo.findById(id).orElseThrow(() -> new GroceryNotFoundException("Grocery with id " + id + " does not exists"));
		repo.deleteById(id);
		return "Grocery with id " + id + " is deleted successfully";

	}

	public String updateGrocery(Grocery grocery,int id) throws GroceryNotFoundException {
		// TODO Auto-generated method stub
		repo.findById(id).orElseThrow(
				() -> new GroceryNotFoundException("Grocery with id " + id + " does not exists"));
		repo.save(grocery);
		return "Grocery with id " + id + " is updated successfully";
	}


}
