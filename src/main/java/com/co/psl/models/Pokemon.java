package com.co.psl.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.google.gson.Gson;

import net.minidev.json.JSONObject;

//This entity will map data to Pokemon table
@Entity
public class Pokemon {
	
	//Object id
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
    private String name;
    @OneToMany()
    private List<PokemonTypes> type;
    @OneToMany()
    private List<PokemonTypes> weakness;
    @OneToOne
    private Pokemon evolution;
    @Column()
    private String image;
 
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PokemonTypes> getType() {
		return type;
	}

	public void setType(List<PokemonTypes> type) {
		this.type = type;
	}

	public List<PokemonTypes> getWeakness() {
		return weakness;
	}

	public void setWeakness(List<PokemonTypes> weakness) {
		this.weakness = weakness;
	}

	public Pokemon getEvolution() {
		return evolution;
	}

	public void setEvolution(Pokemon evolution) {
		this.evolution = evolution;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	@Override
	public String toString(){
		Gson gson = new Gson();
		JSONObject responce = new JSONObject();
		responce.put("id", id);
		responce.put("name", name);
		return gson.toJson(responce);
	}

}