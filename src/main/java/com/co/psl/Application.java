package com.co.psl;


import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.co.psl.config.PokemonDAO;
import com.co.psl.models.Pokemon;
import com.co.psl.repositories.PokemonRepository;

@SpringBootApplication
public class Application {
	@Autowired
	PokemonDAO pokemonRepository;
	
	private static final Logger log = Logger.getLogger(Application.class);
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public CommandLineRunner demo(){
    	return (args)->{
	
    		// fetch all pokemons
			/*log.info("****************** Pokemons found with findAll():");
			log.info("-------------------------------");
			for (Pokemon pokemon : pokemonRepository.getPokemonRepository().findAll()) {
				log.info(pokemon.toString());
			}
			log.info("");*/
    	};
    }
}
