package com.pokedex.services;

import com.pokedex.dao.PokemonListDao;
import com.pokedex.models.PokemonList;

public class PokemonListServices {
    private final PokemonListDao pokemonListDao = new PokemonListDao();

    public void insertPokemonListOwned(String pokemonid , String userid){
        pokemonListDao.insertPokemonListOwned( pokemonid , userid);
    }
    public void insertPokemonListWanted(String pokemonid , String userid){
        pokemonListDao.insertPokemonListWanted( pokemonid , userid);
    }


}
