package com.co.psl.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.psl.models.Pokemon;
import com.co.psl.models.PokemonTypes;
import com.co.psl.repositories.PokemonRepository;
import com.co.psl.repositories.PokemonTypesRepository;

@Component
public class PokemonDAO {
	@Autowired
	private PokemonRepository pokemonRepository;
	@Autowired
	private PokemonTypesRepository typesRepository;
	
	@PostConstruct
	public void pokemonSetUp() {
		
		//PokemonTypeRepository data saving
		PokemonTypes electric = new PokemonTypes("Electric");
		PokemonTypes grass = new PokemonTypes("Grass");
		PokemonTypes poison = new PokemonTypes("Poison");
		PokemonTypes fire = new PokemonTypes("Fire");
		PokemonTypes flying = new PokemonTypes("Flying");
		PokemonTypes ice = new PokemonTypes("Ice");
		PokemonTypes physic = new PokemonTypes("Physic");
		PokemonTypes ground = new PokemonTypes("Ground");
		PokemonTypes water = new PokemonTypes("Water");
		PokemonTypes rock = new PokemonTypes("Rock");
		
		typesRepository.saveAndFlush(electric);
		typesRepository.saveAndFlush(grass);
		typesRepository.saveAndFlush(poison);
		typesRepository.saveAndFlush(fire);
		typesRepository.saveAndFlush(flying);
		typesRepository.saveAndFlush(ice);
		typesRepository.saveAndFlush(physic);
		typesRepository.saveAndFlush(ground);
		typesRepository.saveAndFlush(water);
		typesRepository.saveAndFlush(rock);
		
		//PokemonRepository data saving
		Pokemon raichu = new Pokemon();
		raichu.setName("Raichu");
		raichu.setImage("https://goo.gl/MiOSbH");
		raichu.setEvolution(null);
		raichu.setType(Arrays.asList(electric));
		raichu.setWeakness(Arrays.asList(poison));
		pokemonRepository.saveAndFlush(raichu);
		
		Pokemon pikachu = new Pokemon();
		pikachu.setName("Pikachu");
		pikachu.setImage("https://goo.gl/T1rXHl");
		pikachu.setEvolution(raichu);
		raichu.setType(Arrays.asList(electric));
		raichu.setWeakness(Arrays.asList(poison));
		pokemonRepository.saveAndFlush(pikachu);
		
		Pokemon bulbasaur = new Pokemon();
		pikachu.setName("Bulbasaur");
		pikachu.setImage("https://goo.gl/NSvqCU");
		pikachu.setEvolution(null);
		raichu.setType(Arrays.asList(grass, poison));
		raichu.setWeakness(Arrays.asList(fire, ice, flying, physic));
		pokemonRepository.saveAndFlush(bulbasaur);
		
		Pokemon charizard = new Pokemon();
		pikachu.setName("Charizard");
		pikachu.setImage("https://goo.gl/0EQHsC");
		pikachu.setEvolution(null);
		raichu.setType(Arrays.asList(fire, flying));
		raichu.setWeakness(Arrays.asList(water, electric, rock, ice));
		pokemonRepository.saveAndFlush(charizard);
		
		Pokemon electabuzz = new Pokemon();
		pikachu.setName("Electabuzz");
		pikachu.setImage("https://goo.gl/0EQHsC");
		pikachu.setEvolution(null);
		raichu.setType(Arrays.asList(electric));
		raichu.setWeakness(Arrays.asList(ground));
		pokemonRepository.saveAndFlush(electabuzz);
		
		Pokemon koffing = new Pokemon();
		pikachu.setName("Electabuzz");
		pikachu.setImage("https://goo.gl/0Qjktf");
		pikachu.setEvolution(null);
		raichu.setType(Arrays.asList(poison));
		raichu.setWeakness(Arrays.asList(ground, physic));
		pokemonRepository.saveAndFlush(koffing);
	}
	
	public ArrayList<Pokemon> getPokemonRepository(){
		PokemonDTO DTOobject = new PokemonDTO();
		return DTOobject.serializePokemonArray(pokemonRepository.findAll());
	}
	
	public ArrayList<PokemonTypes> getTypesRepository(){
		PokemonDTO DTOobject = new PokemonDTO();
		return DTOobject.serializePokemonTypesArray(typesRepository.findAll());
	}
	


	
}
