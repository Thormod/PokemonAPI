package com.co.psl.repositories.transformers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.co.psl.models.Pokemon;
import com.co.psl.repositories.DTO.PokemonDTO;

@Component
public class PokemonTransformer {

	public PokemonDTO toDto(Pokemon pokemon){
		PokemonTypesTransformer typesTransformer = new PokemonTypesTransformer();
		PokemonDTO dto = new PokemonDTO();
		dto.setId(pokemon.getId());
		dto.setName(pokemon.getName());
		dto.setImage(pokemon.getImage());
		if(pokemon.getEvolution() != null){
			dto.setEvolution(pokemon.getEvolution().getId());
		}
		dto.setTypes(typesTransformer.toArrayList(pokemon.getType()));
		dto.setWeakness(typesTransformer.toArrayList(pokemon.getWeakness()));
		
		return dto;
	}
	
	public ArrayList<PokemonDTO> toArrayList(List<Pokemon> pokemonList){
		ArrayList<PokemonDTO> responce = new ArrayList<PokemonDTO>();
		PokemonTransformer pokemonTransformer = new PokemonTransformer();
		for(Pokemon currentPokemon : pokemonList){
			responce.add(pokemonTransformer.toDto(currentPokemon));			
		}
		return responce;
	}
}
