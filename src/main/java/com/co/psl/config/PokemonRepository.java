package com.co.psl.config;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.co.psl.models.Pokemon;

public interface PokemonRepository extends CrudRepository<Pokemon, Long> {
	List<Pokemon> findByName(String name);
}
