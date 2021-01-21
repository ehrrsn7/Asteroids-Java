package Asteroids.Objects;

import java.awt.Point;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import Asteroids.Driver;

public abstract class FlyingObject {

    // attributes
    public String name;
    protected Image image;
    protected Point point;
    protected Point velocity;
    protected double direction;
    protected int r; // hitbox radius
    protected boolean wrap;
    protected boolean debug;

    // constructor
    protected FlyingObject() {
        name        = "Unknown Flying Object";
        point       = new Point();
        velocity    = new Point();
        r           = 0;
        wrap        = false;
        debug       = false;
    }

    // abstract methods
    public abstract void draw(Graphics graphics);
    
    // update
    public void update() {
        if (debug) System.out.print("\n" + name + ".update()");
        if (debug) System.out.print(" p(" + point.toString() + ") v(" + velocity.toString() + ")");
        
        // move
        point.translate(velocity.x, velocity.y);

        // wrap edges
        wrap();
    }

    // public helper methods
    public void accelerate() {
        System.out.println(name + ".accelerate()");
        velocity.translate(0, -2);
    }

    // protected helper methods
    protected void importImage(String imageFilname) {
        image = Toolkit.getDefaultToolkit().getImage(imageFilname);
    }

    private void wrap() {
        if (!wrap) return;
        if (point.x > Driver.screenWidth + r) {
            point.x = -r;
            return;
        }
        else if (point.x < -r) {
            point.x = Driver.screenWidth + r;
            return;
        }

        if (point.y < -r) {
            point.y = Driver.screenHeight + r;
            return;
        }
        else if (point.y > Driver.screenHeight + r) {
            point.y = -r;
            return;
        }
    }
}
