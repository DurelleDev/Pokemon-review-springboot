package com.pokemonreview.api.repository;

import com.pokemonreview.api.models.Pokemon;
import com.pokemonreview.api.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//Name of the entity that is linked to the repository. and put the actual value of primary key
//@Repository
public interface PokemonRepository extends JpaRepository <Pokemon, Integer> {
    List<Review> findByPokemonId(int pokemongId);
}
