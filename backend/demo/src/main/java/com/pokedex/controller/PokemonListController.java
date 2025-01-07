package com.pokedex.controller;

import com.pokedex.models.PokemonList;
import com.pokedex.services.PokemonListServices;
import io.javalin.Javalin;

import java.util.UUID;

public class PokemonListController {
    private PokemonListServices pokemonListServices = new PokemonListServices();
    private String apiVersionV1 = "/api/v1";

    public void registerRoutes(Javalin app){
        app.post(apiVersionV1 + "/wanted", ctx -> {
           PokemonList pokemonList = pokemonListServices.insertPokemonList(PokemonList pokemonList);
            ctx.json(pokemonList);
        });

        app.post(apiVersionV1 + "/owned", ctx -> {
            PokemonList pokemonList = pokemonListServices.insertPokemonList(PokemonList pokemonList);
            ctx.json(pokemonList);
        });
    }
}
