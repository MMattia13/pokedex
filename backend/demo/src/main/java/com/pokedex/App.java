package com.pokedex;

<<<<<<< HEAD
import com.pokedex.utility.DatabaseConnection;

import io.javalin.Javalin;

import static io.javalin.Javalin.create;

=======
/**
 * Hello world!
 *
 */
>>>>>>> 32dddd9cac8f9276c021d44932115da3eb7637b1
public class App 
{
    public static void main( String[] args )
    {
<<<<<<< HEAD
        Javalin app = create(config -> {config.plugins.enableCors
                (cors -> cors.add(it -> it.anyHost()));})
                .start(8082);
        DatabaseConnection db = DatabaseConnection.getInstance();
        System.out.println("Server is running on port 8001");
    }
}

// StudentController studentController = new StudentController();
// studentController.registerRoutes(app);
=======
        System.out.println( "Hello World!" );
    }
}
>>>>>>> 32dddd9cac8f9276c021d44932115da3eb7637b1
