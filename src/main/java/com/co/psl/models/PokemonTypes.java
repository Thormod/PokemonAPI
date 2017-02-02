package com.co.psl.models;

public class PokemonTypes {
	private int id;
	private String type;
	
	public PokemonTypes(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	
	public int getId() {
		return id;
	}
	
	public String getType() {
		return type;
	}
}
