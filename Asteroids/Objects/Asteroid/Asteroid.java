
package Asteroids.Objects.Asteroid;

import Asteroids.Game.Asteroids;
import Asteroids.Objects.FlyingObject;

enum positioning {
    random,
    specific
}

enum whichAsteroid {
    asteroidLarge,
    asteroidMedium,
    asteroidSmall
}

public abstract class Asteroid extends FlyingObject {
    
    // constructor
    protected Asteroid() {
        name = "UnknownAsteroid";
        System.out.println(name + " created.");

        // wrap
        wrap = true;

        // set random location
        point.setLocation(
            Asteroids.getScreenDimensions().width * Math.random(),
            Asteroids.getScreenDimensions().height * Math.random()
        );

        // set random velocity angle
        direction = 360.0 * Math.random();
    }
}
