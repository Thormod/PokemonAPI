package com.co.psl.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.psl.models.Pokemon;
import com.co.psl.models.PokemonTypes;
import com.co.psl.repositories.PokemonRepository;
import com.co.psl.repositories.PokemonTypesRepository;
import com.co.psl.repositories.DTO.RepositoryDTO;

@Component
public class PokemonDAO {
	@Autowired
	private PokemonRepository pokemonRepository;
	@Autowired
	private PokemonTypesRepository typesRepository;
	
	private List<Pokemon> pokemonList;
	private List<PokemonTypes> pokemonTypeList;
	
	
	public List<Pokemon> getPokemonList() {
		RepositoryDTO DTOobject = new RepositoryDTO();
		return DTOobject.serializePokemonArray(pokemonList);
	}

	public List<PokemonTypes> getPokemonTypeList() {
		RepositoryDTO DTOobject = new RepositoryDTO();
		return DTOobject.serializePokemonTypesArray(pokemonTypeList);
	}

	public ArrayList<Pokemon> getPokemonRepository(){
		RepositoryDTO DTOobject = new RepositoryDTO();
		return DTOobject.serializePokemonArray(pokemonRepository.findAll());
	}
	
	public ArrayList<PokemonTypes> getTypesRepository(){
		RepositoryDTO DTOobject = new RepositoryDTO();
		return DTOobject.serializePokemonTypesArray(typesRepository.findAll());
	}
	
}
