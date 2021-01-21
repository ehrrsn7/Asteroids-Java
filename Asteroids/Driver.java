/**********************************
 * ASTEROIDS
 * driver file: includes main()
 * used example by leonardo-ono:
 * https://github.com/leonardo-ono/Java2DAsteroidsSurvival
 * (note that our code is very different, I mainly just used his for reference)
 **********************************/

package Asteroids;

// import
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Point;
import Asteroids.Game.*;

// class definition
public class Driver {

    /** Static Constants **/
    public static final int screenWidth = 500;
    public static final int screenHeight = 400;

    public static final Dimension windowDimensions = new Dimension
        (screenWidth, screenHeight);
    public static final Point screenCenter = new Point
        (screenWidth/2, screenHeight/2);

    /** Attributes **/
    private Asteroids game;

    /** Main **/
    public static void main(String[] args) {
        // make an instance of the current class we are in
        Driver d = new Driver();

        // now, to refer to Driver class methods in a non-static way, call them by inserting 'd.' beforehand
        d.setUpGame();
        d.setUpWindow();
        d.gameLoop();
    }

    /** Methods **/
    private void setUpGame() {
        System.out.println("Setting up Game.");
        game = new Asteroids();
    }

    private void gameLoop() {
        System.out.println("Setting up " + game.name + " game loop.");
        tickInit();
        while (isRunning) tick();
        System.out.println("Exiting game loop.");
    }

    private void setUpWindow() {
        System.out.println("Setting up " + game.name + " game window.");
        renderInit();
    }
 
    /** TICK **/
    public static boolean isRunning = true;
    private long before;
    private long now;
    private double amountOfTicks;
    private double ns;
    private double delta;
    private long timer;
    private int frames;

    private void tickInit() {
        frames = 0;
        delta = 0;
        timer = System.currentTimeMillis();
        before = System.nanoTime();
        amountOfTicks = 60.0;
        ns = 1000000000 / amountOfTicks;
    }

    private void tick() {
        // code from https://gamedev.stackexchange.com/questions/52841/the-most-efficient-and-accurate-game-loop

        now = System.nanoTime();
        delta += (now - before) / ns;
        before = now;

        while(delta >= 1) {
            game.update();
            delta--;
        }
        frames++;

        if (System.currentTimeMillis() - timer > 1000) {
            timer += 1000;
            frames = 0;
        }
        before = System.nanoTime();
    }

    /** RENDER **/
    private void renderInit() {
        JPanel jpanel = new JPanel();
        jpanel.setPreferredSize(windowDimensions);
        game.setPreferredSize(Driver.windowDimensions);
        game.getContentPane().add(jpanel);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setLocationRelativeTo(null);
        game.pack();
        game.setVisible(true);
    }
}
