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
    public ResponseEntity<List> getAllPokemon(){
        ArrayList<Pokemon> pokemonList = new ArrayList<>();

        pokemonList.add(new Pokemon(0,"Pikachu", "Electric"));
        pokemonList.add(new Pokemon(1,"Charmander", "Water"));
        pokemonList.add(new Pokemon(2,"PudgyBudgy", "Earth"));

        return new ResponseEntity<>(pokemonList, HttpStatus.CREATED);
    }

    @GetMapping("pokemon/{id}")
    public Pokemon getSpecificPokemon(@PathVariable int id){
        return new Pokemon(id, "Pudgy", "Earth");
    }

//    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("pokemon/create")
    public ResponseEntity<Pokemon> createPokemon(@RequestBody Pokemon pokemon){

        System.out.println(pokemon.getName());
        System.out.println(pokemon.getType());

        return new ResponseEntity<>(pokemon, HttpStatus.CREATED);
    }

    @PutMapping("pokemon/{id}/update")
    public ResponseEntity<Pokemon> updatePokemon(@RequestBody Pokemon pokemon, @PathVariable("id") int pokemonId){
        System.out.println(pokemon.getName());
        System.out.println(pokemon.getType());

        return new ResponseEntity<>(pokemon, HttpStatus.CREATED);
    }



}

