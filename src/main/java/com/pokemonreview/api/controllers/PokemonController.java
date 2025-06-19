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
   public ResponseEntity<List<Pokemon>> getAllPokemon(){
        List<Pokemon> pokemonList = new ArrayList<>();
        pokemonList.add(new Pokemon(0, "Charmander", "Fire"));
        pokemonList.add(new Pokemon(1, "Pikachu", "Electric"));
        pokemonList.add(new Pokemon(2, "Bulbasaur", "Water"));

       return new ResponseEntity<>(pokemonList, HttpStatus.ACCEPTED);
   }

   @GetMapping("pokemon/{id}")
   public ResponseEntity<Pokemon> getPokemon(@PathVariable("id") int pokemonId){
       Pokemon newPokemon = new Pokemon(4, "Charizard", "Fire");

       return new ResponseEntity<>(newPokemon, HttpStatus.ACCEPTED);
   }

   @PostMapping("pokemon/create")
   public ResponseEntity<Pokemon> createPokemon(@RequestBody Pokemon pokemon){

           return new ResponseEntity<>(pokemon, HttpStatus.CREATED);
   }

    @PutMapping("pokemon/{id}/update")
    public ResponseEntity<Pokemon> updatePokemon(@PathVariable("id") int pokemonId, @RequestBody Pokemon pokemon){
       pokemon.setId(pokemonId);
       return new ResponseEntity<>(pokemon, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("pokemon/{id}/delete")
    public ResponseEntity<String> deletePokemon(@PathVariable("id") int pokemonId){
        System.out.println(pokemonId);

        return new ResponseEntity<>("Pokemon with ID: "+pokemonId+" Deleted successfully", HttpStatus.OK);
    }

}

