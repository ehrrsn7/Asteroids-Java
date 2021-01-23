package Asteroids.Objects;

import java.awt.Point;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Polygon;
import java.awt.Image;
import java.awt.Toolkit;

import Asteroids.Game.*;

public abstract class FlyingObject {

    // attributes
    public      String  name        = "Unknown Flying Object";
    protected   int     r           = 0; // hitbox radius
    protected   int     deathTimer  = 0;
    protected   double  direction   = 90;
    protected   int     rotation    = 90;
    protected   Point   point       = new Point();
    protected   Point   velocity    = new Point();
    protected   Polygon shape       = new Polygon();
    // protected   Image   image       = new Image();
    public      boolean alive       = true;
    protected   boolean wrap        = false;
    protected   boolean debug       = false;
    protected   boolean drawHitBox  = false;

    // abstract methods
    public void draw(Graphics graphics) {
        drawHitBox(graphics);
    }
    
    // update
    public void update() {
        if (debug) System.out.print("\n" + name + ".update()");
        if (debug) System.out.print(" p(" + point.toString() + ") v(" + velocity.toString() + ")");
        
        // move
        point.translate(velocity.x, velocity.y);

        // wrap edges
        wrap();

        // handle death timer
        if (deathTimer > 0) deathTimer -= 3;
        else if (deathTimer < 0) alive = false;
    }

    // public helper methods
    public void accelerate(int amount) {
        if (debug) System.out.println
            (name + ".accelerate(" + amount + ") -- new v: " + velocity.toString());

        velocity.translate(
            (int)(amount * Math.cos(Math.toRadians(-rotation))),
            (int)(amount * Math.sin(Math.toRadians(-rotation)))
        );
    }

    public void drawHitBox(Graphics graphics) {
        if (drawHitBox) {
            graphics.setColor(Color.GREEN);
            graphics.drawArc(point.x, point.y, 1, 1, 0, 360);
        }
    }

    protected void addRotation(double diff) {   rotation += diff; }
    protected void addDirection(double diff) {  rotation += diff; }

    // TODO: fix this when implementing image import
    // // protected helper methods
    // protected void importImage(String imageFilname) {
    //     image = Toolkit.getDefaultToolkit().getImage(imageFilname);
    // }

    // private helper methods

    // wrap
    private int buffer = r - 10;
    private void wrap() {

        if (!wrap) return; // quick exit

        // hide wrap off edge of the screen by adding buffer of size: obj.radius
        buffer = r - 10; // include jframe offset

        // wrap left/right
        if (point.x > screenDimensions.width + buffer) {
            point.x = -buffer;
        } else if (point.x < -buffer) {
            point.x = screenDimensions.width + buffer;
        }

        // wrap bottom/top
        if (point.y < -buffer) {
            point.y = screenDimensions.height + buffer;
        } else if (point.y > screenDimensions.height + buffer) {
            point.y = -buffer;
        }
    }

    // FlyingObject.screenDimensions and setters
    protected static Dimension screenDimensions = new Dimension();

    public static void setScreenDimensions(Dimension d) {
        screenDimensions = d;
    }

    public static void setScreenDimensions() {
        screenDimensions = Asteroids.getScreenDimensions();
    }
}
