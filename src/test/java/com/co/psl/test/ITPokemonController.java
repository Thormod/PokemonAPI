package com.co.psl.test;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.co.psl.models.Pokemon;
import com.co.psl.models.PokemonTypes;
import com.co.psl.repositories.PokemonRepository;
import com.co.psl.repositories.PokemonTypesRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ITPokemonController {
	@Autowired
	PokemonTypesRepository pokemonTypesRepository;
	
	@Autowired
	PokemonRepository pokemonRepository;
	
	@Test
    public void saveTypes() {
		PokemonTypes electric = new PokemonTypes("Electric");
		pokemonTypesRepository.save(electric);
     
		List<PokemonTypes> result = pokemonTypesRepository.findByType("Electric");
      
		assertThat(result.size(), is(1));
		assertThat(result, hasItem(electric));
    }
	
	@Test
	public void savePokemons(){
		PokemonTypes electric = new PokemonTypes("Electric");
		pokemonTypesRepository.save(electric);
		PokemonTypes poison = new PokemonTypes("Poison");
		pokemonTypesRepository.save(poison);
		
		Pokemon raichu = new Pokemon();
		raichu.setName("Raichu");
		raichu.setImage("https://goo.gl/MiOSbH");
		raichu.setEvolution(null);
		raichu.setType(Arrays.asList(electric));
		raichu.setWeakness(Arrays.asList(poison));
		pokemonRepository.save(raichu);
		
		
		List<Pokemon> result = pokemonRepository.findByName("Raichu");
		
		assertThat(result.size(),is(1));
		assertThat(result, hasItem(raichu));
	}

}
