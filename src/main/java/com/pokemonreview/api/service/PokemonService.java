package com.pokemonreview.api.service;

import com.pokemonreview.api.dto.PokemonDto;
import com.pokemonreview.api.dto.PokemonResponse;

public interface PokemonService {
  PokemonDto createPokemon(PokemonDto pokemonDto);
  PokemonResponse getAllPokemon(int pageNo, int pageSize);
  PokemonDto getSpecificPokemon(int pokemonId);
  PokemonDto updatePokemon(int pokemonId, PokemonDto pokemonDto);
  void deletePokemon(int pokemonId);

}
