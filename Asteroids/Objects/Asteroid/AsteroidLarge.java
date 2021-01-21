
package Asteroids.Objects.Asteroid;

import java.awt.Graphics;
import java.awt.Color;

public class AsteroidLarge extends Asteroid {

    // constructor
    public AsteroidLarge() {
        name = "LargeAsteroid";
        System.out.println(name + " created.");
        r = 20;
        double speed = 10;
        velocity.setLocation(
            speed * Math.cos(direction),
            speed * Math.sin(direction)
        );
    }

    // methods
    @Override
    public void draw(Graphics graphics) {
        // System.out.println(name + ".draw()");
        graphics.setColor(Color.GRAY);
        graphics.drawArc(point.x, point.y, r, r, 0, 360);
    }
}
