package com.co.psl.config;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.psl.models.Pokemon;
import com.co.psl.models.PokemonTypes;

@Component
public class PokemonDAO {
	@Autowired
	private PokemonRepository pokemonRepository;
	@Autowired
	private PokemonTypesRepository typesRepository;
	
	private ArrayList<PokemonTypes> avaibleTypes;
	private ArrayList<Pokemon> avaiblePokemons;

	@PostConstruct
	public void pokemonSetUp() {
		//ArrayList for types
		avaibleTypes = new ArrayList<PokemonTypes>();
		avaibleTypes.add(new PokemonTypes(0, "Electric"));
		avaibleTypes.add(new PokemonTypes(1, "Grass"));
		avaibleTypes.add(new PokemonTypes(3, "Poison"));
		avaibleTypes.add(new PokemonTypes(4, "Fire"));
		avaibleTypes.add(new PokemonTypes(5, "Flying"));
		avaibleTypes.add(new PokemonTypes(6, "Ice"));
		avaibleTypes.add(new PokemonTypes(7, "Physic"));
		avaibleTypes.add(new PokemonTypes(8, "Ground"));

		//ArrayList for pokemons
		avaiblePokemons = new ArrayList<Pokemon>();
		avaiblePokemons.add(new Pokemon(1, "Pikachu", new String[] { "Electric" }, new String[] { "Ground" }, 2,
				"https://goo.gl/T1rXHl"));
		avaiblePokemons.add(new Pokemon(2, "Bulbasaur", new String[] { "Grass", "Poison" },
				new String[] { "Fire", "Ice", "Flying", "Physic" }, 0, "https://goo.gl/NSvqCU"));
		avaiblePokemons.add(new Pokemon(3, "Charizard", new String[] { "Fire", "Flying" },
				new String[] { "Ground", "Water", "Rock", "Electric", "Ice" }, 3, "https://goo.gl/0EQHsC"));
		avaiblePokemons.add(new Pokemon(4, "Electabuzz", new String[] { "Electric" }, new String[] { "Ground" }, 2,
				"https://goo.gl/3dhOzV"));
		avaiblePokemons.add(new Pokemon(5, "Koffing", new String[] { "Posion" }, new String[] { "Ground", "Physic" }, 1,
				"https://goo.gl/0Qjktf"));
		
		//PokemonRepository data saving
		pokemonRepository.save(new Pokemon(1, "Pikachu", new String[] { "Electric" }, new String[] { "Ground" }, 2,
				"https://goo.gl/T1rXHl"));
		pokemonRepository.save(new Pokemon(2, "Bulbasaur", new String[] { "Grass", "Poison" },
				new String[] { "Fire", "Ice", "Flying", "Physic" }, 0, "https://goo.gl/NSvqCU"));
		pokemonRepository.save(new Pokemon(3, "Charizard", new String[] { "Fire", "Flying" },
				new String[] { "Ground", "Water", "Rock", "Electric", "Ice" }, 3, "https://goo.gl/0EQHsC"));
		pokemonRepository.save(new Pokemon(4, "Electabuzz", new String[] { "Electric" }, new String[] { "Ground" }, 2,
				"https://goo.gl/3dhOzV"));
		pokemonRepository.save(new Pokemon(5, "Koffing", new String[] { "Posion" }, new String[] { "Ground", "Physic" }, 1,
				"https://goo.gl/0Qjktf"));
		
		//PokemonTypeRepository data saving
		typesRepository.save(new PokemonTypes(0, "Electric"));
		typesRepository.save(new PokemonTypes(1, "Grass"));
		typesRepository.save(new PokemonTypes(3, "Poison"));
		typesRepository.save(new PokemonTypes(4, "Fire"));
		typesRepository.save(new PokemonTypes(5, "Flying"));
		typesRepository.save(new PokemonTypes(6, "Ice"));
		typesRepository.save(new PokemonTypes(7, "Physic"));
		typesRepository.save(new PokemonTypes(8, "Ground"));

	}

	public ArrayList<PokemonTypes> getAvaibleTypes() {
		return avaibleTypes;
	}

	public ArrayList<Pokemon> getAvaiblePokemons() {
		return avaiblePokemons;
	}
	
	public PokemonRepository getPokemonRepository(){
		return pokemonRepository;
	}
	
	public PokemonTypesRepository getTypesRepository(){
		return typesRepository;
	}
}
