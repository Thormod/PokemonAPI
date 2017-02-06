package com.co.psl.repositories.DTO;

import java.util.ArrayList;

public class PokemonDTO {
	
	private long id;
	private String name;
	private long evolution;
	private String image;
	private ArrayList<PokemonTypeDTO> types;
	private ArrayList<PokemonTypeDTO> weakness;
	
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
	public long getEvolution() {
		return evolution;
	}
	public void setEvolution(long evolution) {
		this.evolution = evolution;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public ArrayList<PokemonTypeDTO> getTypes() {
		return types;
	}
	public void setTypes(ArrayList<PokemonTypeDTO> types) {
		this.types = types;
	}
	public ArrayList<PokemonTypeDTO> getWeakness() {
		return weakness;
	}
	public void setWeakness(ArrayList<PokemonTypeDTO> weakness) {
		this.weakness = weakness;
	}
	
	
	
	
}
