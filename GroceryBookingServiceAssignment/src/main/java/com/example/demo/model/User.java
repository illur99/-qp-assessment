package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	@OneToMany(mappedBy= "user",cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<Grocery> grocery;
	public User() {
		super();
	}
	public User(int userId, String userName, List<Grocery> grocery) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.grocery = grocery;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<Grocery> getGrocery() {
		return grocery;
	}
	public void setGrocery(List<Grocery> grocery) {
		this.grocery = grocery;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", grocery=" + grocery + "]";
	}
	


}
