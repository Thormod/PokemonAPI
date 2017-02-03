package com.co.psl.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//This entity will map data to PokemonType table
@Entity
public class PokemonTypes {
	//Object id
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(unique = true, nullable = false)
	private String type;
	
	//JPA Constructor
	protected PokemonTypes() {};
	
	//Constructor
	public PokemonTypes(String type) {
		super();
		this.type = type;
	}
	
	//Getters
	public int getId() {
		return id;
	}
	public String getType() {
		return type;
	}
	//Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setType(String type) {
		this.type = type;
	}
	 
	
	
}
