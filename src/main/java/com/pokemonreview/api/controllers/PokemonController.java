package com.pokemonreview.api.controllers;

import com.pokemonreview.api.models.Pokemon;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class PokemonController {

    @GetMapping("pokemon")
    public ResponseEntity<List<Pokemon>> getAllPokemons(){
        List<Pokemon> pokemons = new ArrayList<>();

        pokemons.add(new Pokemon(1,"Squirtle", "Water"));
        pokemons.add(new Pokemon(2,"Pikachu", "Electric"));
        pokemons.add(new Pokemon(3,"Charmander", "Fire"));

        return ResponseEntity.ok(pokemons);
    }

    @GetMapping("pokemon/{id}")
    public Pokemon pokemonDetail(@PathVariable int id){
        return new Pokemon(id, "Squirtle", "Water");
    }

    @PostMapping("pokemon/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Pokemon> createPokemon(@RequestBody Pokemon pokemon){

       System.out.println(pokemon.getName());
       System.out.println(pokemon.getType());

       return new ResponseEntity<>(pokemon, HttpStatus.CREATED);

   }



}

