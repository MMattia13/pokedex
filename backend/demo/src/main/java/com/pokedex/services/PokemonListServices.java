package com.pokedex.services;

import com.pokedex.dao.PokemonListDao;
import com.pokedex.models.PokemonList;

public class PokemonListServices {
    private final PokemonListDao pokemonListDao = new PokemonListDao();

    public PokemonList insertPokemonList(PokemonList pokemonList){
        return pokemonListDao.insertPokemonList(pokemonList);
    }
}
