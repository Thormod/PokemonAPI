package com.co.psl.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.co.psl.Application;
import com.co.psl.config.PokemonDAO;
import com.co.psl.repositories.DTO.RepositoryDTO;
import com.google.gson.Gson;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UTPokemonController {

	RepositoryDTO DTOobject = new RepositoryDTO();
	private static final Logger log = Logger.getLogger(Application.class);
	
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
		mockMvc.perform(get("/pokemons"))
		.andExpect(status().isOk())
        .andExpect(jsonPath("$[0].id").exists())
        .andExpect(jsonPath("$[0].name").exists())
        .andExpect(jsonPath("$[0].type").exists())
        .andExpect(jsonPath("$[0].weakness").exists())
        .andExpect(jsonPath("$[0].evolution").exists())
        .andExpect(jsonPath("$[0].image").exists()
        );
	}
	
    @Test
    public void searchPokemonByPikachuShouldReturnPikachu() throws Exception {
        mockMvc.perform(get("/pokemons").param("name", "Pikachu"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$").exists())
        .andExpect(jsonPath("$[0].id").value("2"))
        .andExpect(jsonPath("$[0].name").value("Pikachu")
        );

    }
    
    @Test
    public void searchPokeminId1ShouldReturnRaichu() throws Exception {
        mockMvc.perform(get("/pokemons/1"))
        .andExpect(status().isOk())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value("1"))
        .andExpect(jsonPath("$.name").value("Raichu")
        );
    }
    @Test
    public void getAllTypes() throws Exception {
        mockMvc.perform(get("/types"))
        .andExpect(status().isOk())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].id").exists())
        .andExpect(jsonPath("$[0].type").exists()
        );

    }
    
    @Test
    public void searchTypesId1ShouldReturnElectric() throws Exception {
        mockMvc.perform(get("/types/1"))
        .andExpect(status().isOk())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value("1"))
        .andExpect(jsonPath("$.type").value("Electric")
        );
    }
    
    @Test
	public void typeNotFoundPathParam() throws Exception{
		mockMvc.perform(get("/types/114"))
		.andExpect(status().isOk())
		.andExpect(content().string(""));
	}
    
    @Test
	public void typeNotFoundQueryParam() throws Exception{
		mockMvc.perform(get("/types?type=ikachu"))
		.andExpect(status().isOk())
		.andExpect(content().string(""));
	}
    @Test
	public void nameNotFoundQueryParam() throws Exception{
		mockMvc.perform(get("/pokemons?name=ikachu"))
		.andExpect(status().isOk())
		.andExpect(content().string(""));
	}
    


}
