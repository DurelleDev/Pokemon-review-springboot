package com.pokemonreview.api.service;

import com.pokemonreview.api.dto.PokemonDto;
import com.pokemonreview.api.models.Pokemon;

import java.util.List;

public interface PokemonService {
  PokemonDto createPokemon(PokemonDto pokemonDto);
  List<PokemonDto> getAllPokemon();
  PokemonDto getSpecificPokemon(int pokemonId);
  PokemonDto updatePokemon(int pokemonId, PokemonDto pokemonDto);
  void deletePokemon(int pokemonId);

}
