package com.pokemonreview.api.repository;

import com.pokemonreview.api.models.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Name of the entity that is linked to the repository. and put the actual value of primary key
//@Repository
public interface PokemonRepository extends JpaRepository <Pokemon, Integer> {

}
