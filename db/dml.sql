CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE utenti (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(100) NOT NULL,
    surname VARCHAR(100) NOT NULL
);

CREATE TABLE pokemon (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    national_number VARCHAR(10) NOT NULL,
    gen INT,
    english_name VARCHAR(100) NOT NULL,
    primary_type VARCHAR(50),
    secondary_type VARCHAR(50),
    classification VARCHAR(100),
    hp INT,
    attack INT,
    defense INT,
    sp_attack INT,
    sp_defense INT,
    speed INT,
    abilities_0 VARCHAR(100),
    abilities_1 VARCHAR(100),
    abilities_2 VARCHAR(100),
    is_sublegendary BOOLEAN,
    is_legendary BOOLEAN,
    is_mythical BOOLEAN,
    evochain_0 VARCHAR(100),
    evochain_1 VARCHAR(100),
    evochain_2 VARCHAR(100),
    evochain_3 VARCHAR(100),
    evochain_4 VARCHAR(100),
    evochain_5 VARCHAR(100),
    evochain_6 VARCHAR(100),
    description TEXT,
    image BYTEA
);

CREATE TYPE pokemon_state AS ENUM ('wanted', 'owned');

CREATE TABLE pokemon_list (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    id_pokemon UUID NOT NULL,
    id_utente UUID NOT NULL,
    state pokemon_state NOT NULL,
    FOREIGN KEY (id_pokemon) REFERENCES pokemon(id),
    FOREIGN KEY (id_utente) REFERENCES utenti(id)
);