package Objects;

import java.awt.Color;
import java.awt.Graphics;

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
    
    // attributes

    // constructor
    protected Asteroid() {
        name = "Unknown-Asteroid";
        System.out.println(name + " created.");
    }

    // draw
    public void draw(Graphics graphics) {
        System.out.println(name + ".draw()");
        graphics.setColor(Color.GRAY);
        graphics.drawOval(point.x, point.y, r, r);
    }
}

// todo - implement 3 Asteroid subclasses
