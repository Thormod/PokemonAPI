package com.co.psl.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.psl.models.PokemonTypes;

public interface PokemonTypesRepository extends JpaRepository<PokemonTypes, Long> {
	List<PokemonTypes> findByType(String type);
}
