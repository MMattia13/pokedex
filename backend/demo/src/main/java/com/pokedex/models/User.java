package com.pokedex.models;

import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @NonNull
    private UUID uuid = UUID.randomUUID();

    @NonNull
    private String email;

    @NonNull
    private String password;

    @NonNull
    private String name;

    @NonNull
    private String surname;
}