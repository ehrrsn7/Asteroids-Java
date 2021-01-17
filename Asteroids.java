/**
 * Asteroids Game file
 * 
 * This Game object houses all of the Game objects and methods.
 * Primary Methods:
 * - Update
 * - Display
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

public class Asteroids extends JFrame {

    // attributes
    public String name;
    public JPanel jpanel;
    private int i; // debug
    private int j; // debug

    // constructor
    public Asteroids() {
        name = "Asteroids";
        System.out.println(name + " obj created.");
        i = 0; j = 200; // debug
    }

    // update / advance
    public void update() {
        System.out.println(name + ".update() ");
        display();
    }

    public void display() {
        System.out.print(name + ".display() ");
        // update jframe - repaint
        // TODO: make this work
        revalidate();
        repaint();
    }

    // draw / display
    @Override
    public void paint(Graphics graphics) {
        System.out.print(name + ".paint() ");
        graphics.drawRect(i++, j--, 50, 50);
        System.out.print(i + " ");
    }

    // helper methods
    public void loadJPanel(JPanel jPanel) {
        // parameter: refrence to jframe (window being desplayed on screen)
        // from jframe load jpanel so we can run objects' draw functions
        this.jpanel = jPanel;
    }
}
