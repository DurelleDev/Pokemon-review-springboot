package com.pokemonreview.api.controllers;

import com.pokemonreview.api.models.Pokemon;
import org.hibernate.internal.build.AllowSysOut;
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
        ArrayList<Pokemon> pokemonlist = new ArrayList<>();

        pokemonlist.add(new Pokemon(0, "Pikachu", "Eletric"));
        pokemonlist.add(new Pokemon(1, "Charazard", "Water"));
        pokemonlist.add(new Pokemon(2, "PudgyBudgy", "Water"));

        return new ResponseEntity<>(pokemonlist, HttpStatus.OK);
}

    @GetMapping("pokemon/{id}")
    public Pokemon getPokemonById(@PathVariable("id") int identification){
        return new Pokemon(identification, "Pudgy", "Earth");
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

        return new ResponseEntity<>(pokemon, HttpStatus.OK);
    }



}

