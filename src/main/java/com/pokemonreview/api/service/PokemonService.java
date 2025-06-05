package com.pokemonreview.api.service;

import com.pokemonreview.api.dto.PokemonDto;
import com.pokemonreview.api.repository.PokemonRepository;

public interface PokemonService {
  PokemonDto createPokemon(PokemonDto pokemonDto);
}
