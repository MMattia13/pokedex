package com.pokedex;

import com.pokedex.auth.controller.AuthController;
import com.pokedex.controller.PokemonController;
import com.pokedex.controller.UserController;
import com.pokedex.utility.DatabaseConnection;

import io.javalin.Javalin;

import static io.javalin.Javalin.create;

public class App 
{
    public static void main( String[] args )
    {
        Javalin app = create(config -> {config.plugins.enableCors
                (cors -> cors.add(it -> it.anyHost()));})
                .start(8082);
        DatabaseConnection db = DatabaseConnection.getInstance();

        PokemonController pokemonController = new PokemonController();
        pokemonController.registerRoutes(app);

        UserController userController = new UserController();
        userController.registerRoutes(app);

        AuthController authController = new AuthController();
        authController.registerRoutes(app);

        System.out.println("Server is running on port 8082");
    }
}


