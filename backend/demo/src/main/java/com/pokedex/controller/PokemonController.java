package com.pokedex.controller;

import com.pokedex.models.Pokemon;
import com.pokedex.models.User;
import com.pokedex.services.PokemonServices;
import io.javalin.Javalin;

import java.util.List;
import java.util.UUID;

public class PokemonController {
    private PokemonServices pokemonServices = new PokemonServices();
    private String apiVersionV1 = "/api/v1";

    public void registerRoutes(Javalin app){
        app.get(apiVersionV1 + "/pokedex", ctx ->
        {List<Pokemon> pokemon= pokemonServices.getAllPokemon();
        ctx.json(pokemon);
    });
    }

}
