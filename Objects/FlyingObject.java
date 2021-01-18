package Objects;

import java.awt.Point;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import Game.Asteroids;

public abstract class FlyingObject {

    // attributes
    public String name;
    protected Image image;
    protected Point point;
    protected Point velocity;
    protected int r; // hitbox radius

    // constructor
    protected FlyingObject() {
        name        = "Unknown Flying Object";
        point       = new Point();
        velocity    = new Point();
        r           = 0;
    }

    // abstract methods
    public abstract void draw(Graphics graphics);
    
    // update
    public void update() {
        System.out.print(name + ".update()");
        // point.translate(velocity.x, velocity.y);

        // debug
        System.out.print(" // new position: ");
        System.out.print(point.x);
        System.out.print(", ");
        System.out.println(point.y);
    }

    // public helper methods

    // protected helper methods
    protected void importImage(String imageFilname) {
        image = Toolkit.getDefaultToolkit().getImage(imageFilname);
    }
}
