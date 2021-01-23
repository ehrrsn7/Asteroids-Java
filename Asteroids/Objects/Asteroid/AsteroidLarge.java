
package Asteroids.Objects.Asteroid;

import java.awt.Graphics;
import java.awt.Color;

public class AsteroidLarge extends Asteroid {

    // constants
    public static final int ASTEROID_LARGE_SPEED = 5;

    // constructor
    public AsteroidLarge() {
        name = "LargeAsteroid";
        System.out.println(name + " created.");
        r = 40;
        velocity.setLocation(
            ASTEROID_LARGE_SPEED * Math.cos(Math.toRadians(direction)),
            ASTEROID_LARGE_SPEED * Math.sin(Math.toRadians(direction))
        );
    }

    // methods
    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
        // System.out.println(name + ".draw()");
        graphics.setColor(Color.GRAY);
        graphics.drawArc(point.x, point.y, r, r, 0, 360);
    }
}
