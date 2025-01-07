package com.pokedex.models;

import lombok.*;


import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PokemonList {

    @NonNull
    private UUID id;

    @NonNull
    private Pokemon pokemon;

    @NonNull
    private User user;
    private PokemonState state;

}