package com.pokedex.dao;
import com.pokedex.models.PokemonList;
import com.pokedex.utility.DatabaseConnection;

import java.sql.*;

public class PokemonListDao {

    private Connection connection = DatabaseConnection.getInstance().getConnection();

    public void insertPokemonListOwned(String pokemonid , String userid) {

        String insertPokemonListSQL = "INSERT INTO public.pokemon_list(\n" +
                "\t id_pokemon, id_utente, state)\n" +
                "\tVALUES ( ?, ?, ?::PokemonState);";

        try {
            PreparedStatement psInsertPokemonList = connection.prepareStatement(insertPokemonListSQL);
            psInsertPokemonList.setString(1, pokemonid);
            psInsertPokemonList.setString(2, userid);
            psInsertPokemonList.setString(3, "owned");

            psInsertPokemonList.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void insertPokemonListWanted(String pokemonid , String userid) {

        String insertPokemonListSQL = "INSERT INTO public.pokemon_list(\n" +
                "\t id_pokemon, id_utente, state)\n" +
                "\tVALUES ( ?, ?, ?::PokemonState);";

        try {
            PreparedStatement psInsertPokemonList = connection.prepareStatement(insertPokemonListSQL);
            psInsertPokemonList.setString(1, pokemonid);
            psInsertPokemonList.setString(2,userid);
            psInsertPokemonList.setString(3, "wanted");

            psInsertPokemonList.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
