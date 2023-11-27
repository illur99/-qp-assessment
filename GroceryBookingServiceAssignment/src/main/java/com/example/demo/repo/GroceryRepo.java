package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Grocery;


public interface GroceryRepo extends JpaRepository<Grocery,Integer> {

}
