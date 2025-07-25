package com.pokemonreview.api.service.impl;

import com.pokemonreview.api.dto.PokemonDto;
import com.pokemonreview.api.dto.PokemonResponse;
import com.pokemonreview.api.exceptions.PokemonNotFoundException;
import com.pokemonreview.api.models.Pokemon;
import com.pokemonreview.api.repository.PokemonRepository;
import com.pokemonreview.api.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonServiceImpl implements PokemonService {
    private PokemonRepository pokemonRepository;

    @Autowired
    public PokemonServiceImpl(PokemonRepository pokemonRepository){
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public PokemonDto createPokemon(PokemonDto pokemonDto) {
        Pokemon pokemon = new Pokemon();
        //Mapping
        pokemon.setName(pokemonDto.getName());
        pokemon.setType(pokemonDto.getType());

        Pokemon newPokemon = pokemonRepository.save(pokemon);

        PokemonDto pokemonResponse = new PokemonDto();
        pokemonResponse.setId(newPokemon.getId());
        pokemonResponse.setName(newPokemon.getName());
        pokemonResponse.setType(newPokemon.getType());

        return pokemonResponse;
    }

    @Override
    public PokemonResponse getAllPokemon(int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo, pageSize); // Creates and object to parse your find all entity

        Page<Pokemon> pokemonPages = pokemonRepository.findAll(pageable);
        List<Pokemon> listOfPokemons = pokemonPages.getContent();
        //return pokemonList.stream().map(p -> mapToDto(p)).toList(); Lambda expression ->
        List<PokemonDto> content = listOfPokemons.stream().map(this::mapToDto).toList(); // Double colon

        PokemonResponse response = new PokemonResponse();
        response.setContent(content);
        response.setPageNo(pokemonPages.getNumber());
        response.setPageSize(pokemonPages.getSize());
        response.setTotalElements(pokemonPages.getTotalElements());
        response.setTotalPages(pokemonPages.getTotalPages());


        return response;

    }

    public PokemonDto getSpecificPokemon(int pokemonId){
        Pokemon pokemon = pokemonRepository.findById(pokemonId).orElseThrow(() -> new PokemonNotFoundException("Pokemon could not be found"));

        return mapToDto(pokemon);
    }

    @Override
    public void deletePokemon(int pokemonId){
        Pokemon pokemon = pokemonRepository.findById(pokemonId).orElseThrow(() -> new PokemonNotFoundException("Pokemon could not be deleted"));

        pokemonRepository.deleteById(pokemonId);

    }

    @Override
    public PokemonDto updatePokemon(int pokemonId, PokemonDto pokemonDto){
        Pokemon pokemon = pokemonRepository.findById(pokemonId).orElseThrow(() -> new PokemonNotFoundException("Pokemon could not be updated"));

        pokemon.setName(pokemonDto.getName());
        pokemon.setType(pokemonDto.getType());

        Pokemon updatedPokemon = pokemonRepository.save(pokemon);

        return mapToDto(pokemon);
    }

    private PokemonDto mapToDto(Pokemon pokemon){

        PokemonDto pokemonDto = new PokemonDto();

        pokemonDto.setId(pokemon.getId());
        pokemonDto.setName(pokemon.getName());
        pokemonDto.setType(pokemon.getType());

        return pokemonDto;
    }

    private Pokemon mapToEntity(PokemonDto pokemonDto){

        Pokemon pokemon = new Pokemon();

        //We don't map the ID because it increments on its own when added to the repository
        pokemon.setName(pokemonDto.getName());
        pokemon.setType(pokemonDto.getType());

        return pokemon;
    }

    private PokemonDto mapToResponse(PokemonResponse response, List<PokemonDto> content,
                                          int pageNo, int pageSize, long totalElements, int totalPages, boolean isLast){

        PokemonDto pokemonDto = new PokemonDto();
        response.setContent(content);
        response.setPageNo(pageNo);
        response.setPageSize(pageSize);
        response.setTotalElements(totalElements);
        response.setTotalPages(totalPages);
        response.setLast(isLast);

        return null;
    }


}
