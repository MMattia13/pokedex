package com.pokedex;

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
        System.out.println("Server is running on port 8001");
    }
}

// StudentController studentController = new StudentController();
// studentController.registerRoutes(app);

