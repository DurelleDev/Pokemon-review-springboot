package com.pokemonreview.api.controllers;


import com.pokemonreview.api.dto.PokemonDto;
import com.pokemonreview.api.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/")
public class PokemonController {

    private PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService){
        this.pokemonService = pokemonService;
    }

    @GetMapping("pokemon")
   public ResponseEntity<List<PokemonDto>> getAllPokemon(
           @RequestParam(defaultValue = "0") int pageNo,
           @RequestParam(defaultValue = "10") int pageSize){

       return new ResponseEntity<>(pokemonService.getAllPokemon(pageNo, pageSize), HttpStatus.OK);
   }

   @GetMapping("pokemon/{id}")
   public ResponseEntity<PokemonDto> getPokemon(@PathVariable("id") int pokemonId){
       //Pokemon newPokemon = new Pokemon(4, "Charizard", "Fire");
       return new ResponseEntity<>(pokemonService.getSpecificPokemon(pokemonId), HttpStatus.OK);
   }

   @PostMapping("pokemon/create")
   public ResponseEntity<PokemonDto> createPokemon(@RequestBody PokemonDto pokemonDto){

           return new ResponseEntity<>(pokemonService.createPokemon(pokemonDto), HttpStatus.CREATED);
   }

    @PutMapping("pokemon/{id}/update")
    public ResponseEntity<PokemonDto> updatePokemon(@PathVariable("id") int pokemonId, @RequestBody PokemonDto pokemonDto){
       //pokemon.setId(pokemonId);
       return new ResponseEntity<>(pokemonService.updatePokemon(pokemonId, pokemonDto), HttpStatus.OK);
    }

    @DeleteMapping("pokemon/{id}/delete")
    public ResponseEntity<String> deletePokemon(@PathVariable("id") int pokemonId){

        pokemonService.deletePokemon(pokemonId);
       return new ResponseEntity<>("Pokemon has been deleted", HttpStatus.OK);
    }

}

