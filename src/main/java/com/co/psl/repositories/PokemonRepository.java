package com.co.psl.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.psl.models.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
	List<Pokemon> findByName(String name);
}
