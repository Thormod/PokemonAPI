package com.co.psl.test;
/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.co.psl.config.PokemonDAO;
import com.google.gson.Gson;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PokemonControllerTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	PokemonDAO pokemonRepository;
	
	Gson gson;
	
	@Before
	public void setUp(){
		gson = new Gson();
	}
	
	@Test
	public void tryURL() throws Exception {
		 this.mockMvc.perform(get("/pokemons"))
	        .andExpect(status().isOk());
	}
	
	@Test
    public void getAllPokemon() throws Exception {
		String expectedResponce = gson.toJson(pokemonRepository.getAvaiblePokemons());
		mockMvc.perform(get("/pokemons"))
		.andExpect(status().isOk())
		.andExpect(content().string(containsString(expectedResponce)));
	}
	
	@Test
	public void getSinglePokemonByIdPathParam() throws Exception{
		String expectedResponce = gson.toJson(pokemonRepository.getAvaiblePokemons().get(0));
		mockMvc.perform(get("/pokemons/1"))
		.andExpect(status().isOk())
		.andExpect(content().string(containsString(expectedResponce)));
	}
	
	@Test
	public void idNotFoundPathParam() throws Exception{
		mockMvc.perform(get("/pokemons/114"))
		.andExpect(status().isOk())
		.andExpect(content().string(""));
	}
	
	@Test
	public void getPokemonByNameQueryParam() throws Exception{
		String expectedResponce = gson.toJson(pokemonRepository.getAvaiblePokemons().get(0));
		mockMvc.perform(get("/pokemons?name=Pikachu"))
		.andExpect(status().isOk())
		.andExpect(content().string(containsString(expectedResponce)));
	}
	
	@Test
	public void nameNotFoundQueryParam() throws Exception{
		mockMvc.perform(get("/pokemons?name=ikachu"))
		.andExpect(status().isOk())
		.andExpect(content().string(""));
	}
	
	@Test
	public void getAllTypes() throws Exception{
		String expectedResponce = gson.toJson(pokemonRepository.getAvaibleTypes());
		mockMvc.perform(get("/types"))
		.andExpect(status().isOk())
		.andExpect(content().string(containsString(expectedResponce)));
	}
	
	@Test
	public void getSingleTypeByIdPathParam() throws Exception{
		String expectedResponce = gson.toJson(pokemonRepository.getAvaibleTypes().get(0));
		mockMvc.perform(get("/types/0"))
		.andExpect(status().isOk())
		.andExpect(content().string(containsString(expectedResponce)));
	}
	
	@Test
	public void typeNotFoundPathParam() throws Exception{
		mockMvc.perform(get("/types/114"))
		.andExpect(status().isOk())
		.andExpect(content().string(""));
	}
	
	@Test
	public void getTypeByNameQueryParam() throws Exception{
		String expectedResponce = gson.toJson(pokemonRepository.getAvaibleTypes().get(1));
		mockMvc.perform(get("/types?type=Grass"))
		.andExpect(status().isOk())
		.andExpect(content().string(containsString(expectedResponce)));
	}
	
	@Test
	public void typeNotFoundQueryParam() throws Exception{
		mockMvc.perform(get("/types?type=ikachu"))
		.andExpect(status().isOk())
		.andExpect(content().string(""));
	}

}
