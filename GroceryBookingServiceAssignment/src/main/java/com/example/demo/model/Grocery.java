package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class Grocery {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int groceryId;
	private String groceryName;
	@ManyToOne
	@JsonBackReference
	private User user;

	public Grocery() {
		super();
	}

	public Grocery(int groceryId, String groceryName) {
		super();
		this.groceryId = groceryId;
		this.groceryName = groceryName;
	}

	public int getGroceryId() {
		return groceryId;
	}

	public void setGroceryId(int groceryId) {
		this.groceryId = groceryId;
	}

	public String getGroceryName() {
		return groceryName;
	}

	public void setGroceryName(String groceryName) {
		this.groceryName = groceryName;
	}

	@Override
	public String toString() {
		return "Grocery [groceryId=" + groceryId + ", groceryName=" + groceryName + "]";
	}

}
