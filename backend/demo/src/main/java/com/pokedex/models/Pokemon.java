package com.pokedex.models;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Pokemon {
    @NonNull
    private UUID uuid = UUID.randomUUID();
    @NonNull
    private String nationalNumber;
    private String gen;
    @NonNull
    private String englishName;
    private String primaryType;
    private String secondaryType;
    private String classification;
    private Integer hp;
    private Integer attack;
    private Integer defense;
    private Integer spAttack;
    private Integer spDefense;
    private Integer speed;
    private String abilities0;
    private String abilities1;
    private String abilities2;
    private Boolean isSublegendary;
    private Boolean isLegendary;
    private Boolean isMythical;
    private String evochain0;
    private String evochain1;
    private String evochain2;
    private String evochain3;
    private String evochain4;
    private String evochain5;
    private String evochain6;
    private String description;
    private byte[] image;
}
