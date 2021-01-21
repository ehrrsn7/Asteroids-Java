
package Asteroids.Objects.Asteroid;

import Asteroids.Driver;
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
        name = "Unknown-Asteroid";
        System.out.println(name + " created.");

        // wrap
        wrap = true;

        // set random location
        point.setLocation(
            Driver.windowDimensions.getWidth() * Math.random(),
            Driver.windowDimensions.getHeight() * Math.random()
        );

        // set random velocity angle
        direction = 360.0 * Math.random();
    }
}
