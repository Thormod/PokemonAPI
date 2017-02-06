package com.co.psl.repositories.transformers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.co.psl.models.PokemonTypes;
import com.co.psl.repositories.DTO.PokemonTypeDTO;

@Component
public class PokemonTypesTransformer {

	public PokemonTypeDTO toDto(PokemonTypes type){
		PokemonTypeDTO dto = new PokemonTypeDTO();
		dto.setType(type.getType());
		return dto;
	}
	
	public ArrayList<PokemonTypeDTO> toArrayList(List<PokemonTypes> list){
		ArrayList<PokemonTypeDTO> dto = new ArrayList<PokemonTypeDTO>();
		for(PokemonTypes currentType : list){
			PokemonTypeDTO currentDto = new PokemonTypeDTO();
			currentDto.setType(currentType.getType());
			dto.add(currentDto);
		}
		return dto;
	}
}
