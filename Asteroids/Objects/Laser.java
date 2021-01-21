
package Asteroids.Objects;

import java.awt.Point;
import java.awt.Graphics;
import java.awt.Color;

public class Laser extends FlyingObject {
    
    // constructor
    public Laser(Point pInit, Point vInit) {
        name = "Laser";
        System.out.println(name + " created.");
        point.setLocation(pInit);
        velocity.setLocation(10 * vInit.x, 10 * vInit.y);
        r = 1;
        wrap = true;
    }

    // methods
    public void draw(Graphics graphics) {
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.drawArc(point.x, point.y, r, r, 0, 360);
    }
}
