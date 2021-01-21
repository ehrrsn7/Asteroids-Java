package Asteroids.Objects;

import java.awt.Color;
import java.awt.Graphics;

import Asteroids.Driver;

public class Ship extends FlyingObject {

    // constructor
    public Ship() {
        name    = "Ship";
        r       = 20;
        wrap    = true;
        debug   = true;
        point.setLocation(Driver.screenCenter);
    }

    // methods
    @Override
    public void draw(Graphics graphics) {
        // System.out.println(name + ".draw() [child]");

        // placeholder point
        graphics.setColor(Color.BLUE);
        graphics.drawArc(point.x, point.y, r, r, 0, 360);
    }

    public Laser fire() {
        System.out.print(name + ".fire() ");
        return new Laser(point, velocity);
    }
}
