/**
 * Asteroids Game file
 * 
 * This Game object houses all of the Game objects and methods.
 * Primary Methods:
 * - update()
 * Methods called by update():
 * - paint() [invoked by repaint() in update()]
 */

package Game;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import Objects.*;

public class Asteroids extends JFrame {

    // constants
    public static final boolean DEBUG = false;

    // attributes
    public String name;
    public JPanel jpanel;

    private int i; // debug
    private int j; // debug

    public static final Color backgroundColor = Color.BLACK;
    public static Dimension screenDimensions;
    public static Point screenCenter = new Point();

    // game objects
    private Ship ship;
    private List<Asteroid> asteroids = new ArrayList<>();

    // constructor
    public Asteroids(Dimension dimensions) {
        // initialize components
        name = "Asteroids";
        setDimensions(dimensions);

        System.out.println(name + " obj created.");
        i = 0; j = 200; // debug

        // initialize game objects
        ship = new Ship(screenCenter);
        asteroidBelt(5);
    }

    // update / advance
    public void update() {
        clearTerminalWindow(); // call this first per frame
        System.out.println(name + ".update() ");

        // update screen
        revalidate();
        repaint();

        // update game objects
        ship.update();

        // debug
        System.out.println(screenCenter.toString());
    }

    // draw / display
    @Override
    public void paint(Graphics graphics) {
        System.out.println(name + ".paint() ");

        // reset background color
        /* for reference:
         * [frame size == getSize() .width() and .height() **/
        graphics.setColor(backgroundColor);
        graphics.fillRect(0, 0, getSize().width, getSize().height);

        // draw objects
        ship.draw(graphics);
        // update asteroids
    }

    // public helper methods
    public void loadJPanel(JPanel jPanel) {
        // parameter: refrence to jframe (window being desplayed on screen)
        // from jframe load jpanel so we can run objects' draw functions
        this.jpanel = jPanel;
    }

    public void setDimensions(Dimension dimensions) {
        setPreferredSize(dimensions);
        System.out.println(screenCenter.toString());
        screenCenter.setLocation(
            dimensions.getWidth()/2,
            dimensions.getHeight()/2
        );
    }

    // private helper methods (sorted by order called)
    private void asteroidBelt(int amount) {
        // create 'amount' of asteroids to add to 'this.asteroids'
    }

    private void clearTerminalWindow() {
        // debug: clear terminal window
        System.out.print("\033[H\033[2J");
        System.out.flush();  
    }
}
