package com.co.psl.config;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.co.psl.models.PokemonTypes;

public interface PokemonTypesRepository extends CrudRepository<PokemonTypes, Long> {
	List<PokemonTypes> findByType(String type);
}
