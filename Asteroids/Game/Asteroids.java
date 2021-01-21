/**
 * Asteroids Game file
 * 
 * This Game object houses all of the Game objects and methods.
 * Primary Methods:
 * - update()
 * Methods called by update():
 * - paint() [invoked by repaint() in update()]
 */

package Asteroids.Game;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.ArrayList;

import Asteroids.Driver;
import Asteroids.Objects.*;
import Asteroids.Objects.Asteroid.*;

public class Asteroids extends JFrame {
    
    // constants
    public static final Color backgroundColor = Color.BLACK;
    public static final boolean DEBUG = false;
    private static final long serialVersionUID = 1L;

    // attributes
    public String name;
    public JPanel jpanel;

    // game objects
    private Ship ship;
    private List<Asteroid> asteroids = new ArrayList<>();
    private List<Laser> lasers = new ArrayList<>();

    // constructor
    public Asteroids() {
        // initialize components
        name = "Asteroids";

        System.out.println(name + " obj created.");

        KeyListener listener = new MyKeyListener();
		addKeyListener(listener);
		setFocusable(true);

        // initialize game objects
        ship = new Ship();
        asteroidBelt(5);
    }

    // update / advance
    public void update() {
        // clearTerminalWindow(); // call this first per frame
        // System.out.println(name + ".update() ");

        // update screen
        revalidate();
        repaint();

        // update game objects
        ship.update();
        for (Asteroid asteroid : asteroids) asteroid.update();
        for (Laser laser : lasers) laser.update();
    }

    // draw / display
    @Override
    public void paint(Graphics graphics) {
        // System.out.println(name + ".paint() ");

        // reset background color
        graphics.setColor(backgroundColor);
        graphics.fillRect(0, 0, getWidth(), getHeight()); // getWidth()/getHeight() return screen dimensions

        // draw objects
        ship.draw(graphics);
        for (Asteroid asteroid : asteroids) asteroid.draw(graphics);
        for (Laser laser : lasers) laser.draw(graphics);
    }

    // public helper methods
    public void loadJPanel(JPanel jPanel) {
        // parameter: refrence to jframe (window being desplayed on screen)
        // from jframe load jpanel so we can run objects' draw functions
        this.jpanel = jPanel;
    }

    // private helper methods (sorted by order called)
    private void asteroidBelt(int amount) {
        // create 'amount' of asteroids to add to 'this.asteroids'
        for (int i = 0; i < amount; i++) asteroids.add(new AsteroidLarge());
    }

    private void clearTerminalWindow() {
        // debug: clear terminal window
        System.out.print("\033[H\033[2J");
        System.out.flush();  
    }

    // handle events
    public class MyKeyListener implements KeyListener {
        // handle input

        @Override
		public void keyTyped(KeyEvent e) { }

		@Override
		public void keyPressed(KeyEvent e) {
            // System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));

            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    ship.accelerate();
                    break;

                case 'Q':
                    quit();
                    break;

                case ' ':
                    fireLaser();
                    break;

                default:
                    break;
            }
		}

		@Override
		public void keyReleased(KeyEvent e) { }
    }
    
    private void quit() {
        System.out.println("Asteroids.quit()");
        Driver.isRunning = false;
    }

    private void fireLaser() {
        lasers.add(ship.fire());
    }
}
