package com.co.psl.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

//This entity will map data to PokemonType table
@Entity
public class PokemonTypes {
	//Object id
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(unique = true, nullable = false)
	private String type;
	
	@ManyToMany(mappedBy = "types", cascade = CascadeType.MERGE)
    private List<Pokemon> pokemons_types;
	
	@ManyToMany(mappedBy = "weakness", cascade = CascadeType.MERGE)
    private List<Pokemon> pokemons_weakness;
	
	
	
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
