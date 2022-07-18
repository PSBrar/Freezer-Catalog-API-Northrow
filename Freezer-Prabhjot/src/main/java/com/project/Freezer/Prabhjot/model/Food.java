package com.project.Freezer.Prabhjot.model;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table
public class Food { //Uses JPA annotations to make this class a Food table
					//and allows for entities to be made of it.
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="type")
	private String type;
	
	@Column(name="quantity")
	private Integer quantity;
	
	public Food() {

	}
	
	public Food(long id, String name, String type, Integer quantity) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.quantity = quantity;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
}
