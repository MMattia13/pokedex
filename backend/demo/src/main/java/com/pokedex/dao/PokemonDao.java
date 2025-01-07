package com.pokedex.dao;

import com.pokedex.models.Pokemon;
import com.pokedex.utility.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PokemonDao {
    private Connection connection = DatabaseConnection.getInstance().getConnection();

    public List<Pokemon> getAllPokemon() {

        String selectAllPokemonSQL = "SELECT id, national_number, gen, english_name, primary_type, secondary_type, " +
                "classification, hp, attack, defense, sp_attack, sp_defense, speed, abilities_0, abilities_1, " +
                "abilities_2, is_sublegendary, is_legendary, is_mythical, evochain_0, evochain_1, evochain_2, " +
                "evochain_3, evochain_4, evochain_5, evochain_6, description, image\n" +
                "\tFROM public.pokemon;";

        List<Pokemon> pokemonList= new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(selectAllPokemonSQL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Pokemon pokemon = new Pokemon();
                pokemon.setUuid(rs.getObject("id", java.util.UUID.class));
                pokemon.setNationalNumber(rs.getString("national_number"));
                pokemon.setGen(rs.getString("gen"));
                pokemon.setEnglishName(rs.getString("english_name"));
                pokemon.setPrimaryType(rs.getString("primary_type"));
                pokemon.setSecondaryType(rs.getString("secondary_type"));
                pokemon.setClassification(rs.getString("classification"));
                pokemon.setHp(rs.getInt("hp"));
                pokemon.setAttack(rs.getInt("attack"));
                pokemon.setDefense(rs.getInt("defense"));
                pokemon.setSpAttack(rs.getInt("sp_attack"));
                pokemon.setSpDefense(rs.getInt("sp_defense"));
                pokemon.setSpeed(rs.getInt("speed"));
                pokemon.setAbilities0(rs.getString("abilities_0"));
                pokemon.setAbilities1(rs.getString("abilities_1"));
                pokemon.setAbilities2(rs.getString("abilities_2"));
                pokemon.setIsSublegendary(rs.getBoolean("is_sublegendary"));
                pokemon.setIsLegendary(rs.getBoolean("is_legendary"));
                pokemon.setIsMythical(rs.getBoolean("is_mythical"));
                pokemon.setEvochain0(rs.getString("evochain_0"));
                pokemon.setEvochain1(rs.getString("evochain_1"));
                pokemon.setEvochain2(rs.getString("evochain_2"));
                pokemon.setEvochain3(rs.getString("evochain_3"));
                pokemon.setEvochain4(rs.getString("evochain_4"));
                pokemon.setEvochain5(rs.getString("evochain_5"));
                pokemon.setEvochain6(rs.getString("evochain_6"));
                pokemon.setDescription(rs.getString("description"));
                pokemon.setImage(rs.getBytes("image"));

                pokemonList.add(pokemon);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pokemonList;
    }
}
