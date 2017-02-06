package com.co.psl.repositories.DTO;

import java.util.ArrayList;
import java.util.List;

import com.co.psl.models.Pokemon;
import com.co.psl.models.PokemonTypes;

import net.minidev.json.JSONArray;

public class RepositoryDTO {
	public ArrayList<PokemonTypes> serializePokemonTypesArray(List<PokemonTypes> typesList){
		ArrayList<PokemonTypes> responce = new ArrayList<PokemonTypes>();
		for(PokemonTypes type: typesList){
			responce.add(type);
		}
		return responce;
	}
	public ArrayList<Pokemon> serializePokemonArray(List<Pokemon> pokemonsList){
		ArrayList<Pokemon> responce = new ArrayList<Pokemon>();
		for(Pokemon pokemon: pokemonsList){
			responce.add(pokemon);
		}
		return responce;
	}	
}
