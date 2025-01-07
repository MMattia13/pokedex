package com.pokedex.services;

import com.pokedex.dao.PokemonDao;
import com.pokedex.models.Pokemon;

import java.util.List;

public class PokemonServices {
    private PokemonDao pokemonDao = new PokemonDao();

    public List<Pokemon> getAllPokemon() {
        return  pokemonDao.getAllPokemon();
    }
}
