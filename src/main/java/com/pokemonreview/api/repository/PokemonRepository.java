package com.pokemonreview.api.repository;

import com.pokemonreview.api.models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

//Name of the entity that is linked to the repository. and put the actual value of primary key
public interface PokemonRepository extends JpaRepository <Pokemon, Integer> {

}
