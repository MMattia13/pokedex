package com.pokedex.controller;

import com.pokedex.models.Pokemon;
import com.pokedex.models.PokemonList;
import com.pokedex.services.PokemonListServices;
import io.javalin.Javalin;

import java.util.UUID;

public class PokemonListController {
    private PokemonListServices pokemonListServices = new PokemonListServices();
    private String apiVersionV1 = "/api/v1/{pokemonid}";

    public void registerRoutes(Javalin app){
        app.post(apiVersionV1 + "/wanted", ctx -> {
            String pokemonid = ctx.pathParam("pokemonid");
            String userid = ctx.attribute("userid");
             pokemonListServices.insertPokemonListWanted( pokemonid, userid );
            ctx.status(200).result("succes");
        });

        app.post(apiVersionV1 + "/owned", ctx -> {
            String pokemonid = ctx.pathParam("pokemonid");
            String userid = ctx.attribute("userid");
            pokemonListServices.insertPokemonListWanted( pokemonid, userid );
            ctx.status(200).result("succes");
        });
    }
}
