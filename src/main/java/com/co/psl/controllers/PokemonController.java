package com.co.psl.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.co.psl.config.PokemonDAO;
import com.co.psl.models.Pokemon;
import com.co.psl.repositories.DTO.PokemonDTO;
import com.co.psl.repositories.transformers.PokemonTransformer;

@RestController
public class PokemonController {
	
	
	@Autowired
	PokemonDAO pokemonRepository;
	
	@Autowired
	PokemonTransformer pokemonTransformer;
	
	@RequestMapping(value="/pokemons/{id}", method=RequestMethod.GET)
	@ResponseBody
	public PokemonDTO getPokemonById(@PathVariable("id") int id){
		
		for (Pokemon currentPokemon : pokemonRepository.getPokemonRepository()) {
			if(currentPokemon.getId() == id){
				return pokemonTransformer.toDto(currentPokemon);
			}
		}
		return null;
	}
		
	@RequestMapping(path="/pokemons", method=RequestMethod.GET)
	public @ResponseBody ArrayList<PokemonDTO> listAvaiblePokemons(
			@RequestParam(value="name", required=false) String name){
		
		if(name!=null){
			for (Pokemon currentPokemon : pokemonRepository.getPokemonRepository()) {
				if(currentPokemon.getName().equals(name)){
					ArrayList<PokemonDTO> responce = new ArrayList<PokemonDTO>();
					{
						responce.add(pokemonTransformer.toDto(currentPokemon));
					}
					return responce;
				}
			}
			return null;
		}
		return pokemonTransformer.toArrayList(pokemonRepository.getPokemonRepository());
	}	
}
