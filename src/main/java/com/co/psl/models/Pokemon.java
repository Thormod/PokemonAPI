package com.co.psl.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//This entity will map data to Pokemon table
@Entity
public class Pokemon {
	
	//Object id
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private long id;
    private String name;
    private String[] type;
    private String[] weakness;
    private int evolutionId;
    private String image;
    
    //JPA Constructor
    protected Pokemon() {};
    
    //Constructor
    public Pokemon(long id, String name, String[] type, String[] weakness, int evolutionId, String image) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.weakness = weakness;
		this.evolutionId = evolutionId;
		this.image = image;
	}
    
	//Getters
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String[] getType() {
		return type;
	}
	public String[] getWeakness() {
		return weakness;
	}
	public int getEvolutionId() {
		return evolutionId;
	}
	public String getImage() {
		return image;
	}
	
	//Setters
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setType(String[] type) {
		this.type = type;
	}
	public void setWeakness(String[] weakness) {
		this.weakness = weakness;
	}
	public void setEvolutionId(int evolutionId) {
		this.evolutionId = evolutionId;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	@Override
	public String toString() {
		return String.format("Pokemon [id=%d, name='%s', image='%s']", id, name, image);
	}
}