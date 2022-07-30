package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Home {

	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private int id;
	private String name;
	@Override
	public String toString() {
		return "Home [id=" + id + ", name=" + name + "]";
	}
	
	
}
 