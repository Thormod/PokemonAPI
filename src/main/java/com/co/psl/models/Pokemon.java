
package com.co.psl.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import net.minidev.json.JSONObject;

//This entity will map data to Pokemon table
@Entity
public class Pokemon {
		
	//Object id
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
    private String name;
    @ManyToMany(targetEntity = PokemonTypes.class, cascade = {CascadeType.MERGE})
    @JoinTable(name = "pokemonHasType", joinColumns = {@JoinColumn(name="pokemon_id")},
    									inverseJoinColumns = {@JoinColumn(name = "type_id")})
    @JsonManagedReference
    private List<PokemonTypes> types;
    
    @ManyToMany(targetEntity = PokemonTypes.class, cascade = {CascadeType.MERGE})
    @JoinTable(name = "pokemonHasWeakness", joinColumns = {@JoinColumn(name="pokemon_id")},
    									inverseJoinColumns = {@JoinColumn(name = "type_id")})
    @JsonManagedReference
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
		return types;
	}

	public void setType(List<PokemonTypes> type) {
		this.types = type;
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
	
	public JSONObject toJSON(){
		JSONObject responce = new JSONObject();
		responce.put("id", id);
		responce.put("name", name);
		responce.put("image", image);
		responce.put("type", types);
		responce.put("weakness", weakness);
		responce.put("evolution",(evolution != null)?evolution.getName():"");
		return responce;
	}

}