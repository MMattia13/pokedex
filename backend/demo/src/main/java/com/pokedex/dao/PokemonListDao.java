package com.pokedex.dao;
import com.pokedex.models.PokemonList;
import com.pokedex.utility.DatabaseConnection;

import java.sql.*;

public class PokemonListDao {

    private Connection connection = DatabaseConnection.getInstance().getConnection();

    public PokemonList insertPokemonList(PokemonList pokemonList) {

        String insertPokemonListSQL = "INSERT INTO public.pokemon_list(\n" +
                "\tid, id_pokemon, id_utente, state)\n" +
                "\tVALUES (?, ?, ?, ?::PokemonState);";

        try {
            PreparedStatement psInsertPokemonList = connection.prepareStatement(insertPokemonListSQL);
            psInsertPokemonList.setString(1, pokemonList.getId().toString());
            psInsertPokemonList.setString(2, pokemonList.getPokemon().toString());
            psInsertPokemonList.setString(3, pokemonList.getUser().toString());
            psInsertPokemonList.setString(4, pokemonList.getState().name().toLowerCase());

            psInsertPokemonList.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pokemonList;
    }


}
