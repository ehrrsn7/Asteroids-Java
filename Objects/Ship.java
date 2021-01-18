package Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Ship extends FlyingObject {

    // attributes

    // constructor
    public Ship(Point pInit) {
        name = "Ship";
        point.setLocation(pInit);
        r = 20;
    }

    // define abstract 'draw' method
    @Override
    public void draw(Graphics graphics) {
        System.out.println(name + ".draw() [child]");
  
        // draw a placeholder for the ship: a blue circle

        // placeholder point
        graphics.setColor(Color.BLUE);
        graphics.drawArc(point.x, point.y, r, r, 0, 360);
    }
}
