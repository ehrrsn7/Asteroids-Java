/**********************************
 * ASTEROIDS
 * driver file: includes main()
 * used example by leonardo-ono:
 * https://github.com/leonardo-ono/Java2DAsteroidsSurvival
 * (note that our code is very different, I mainly just used his for reference)
 **********************************/

// import
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JPanel;

// class definition
public class Driver {

    /** MAIN **/
    public static void main(String[] args) {
        // make an instance of the current class we are in
        Driver d = new Driver();

        // now, to refer to Driver class methods in a non-static way, call them by inserting 'd.' beforehand
        d.setUpGame();
        d.setUpWindow();
        d.gameLoop();
    }

    /** GAME **/
    private Asteroids game;

    private void setUpGame() {
        System.out.println("Setting up Game.");
        game = new Asteroids();
    }

    private void gameLoop() {
        System.out.println("Setting up " + game.name + " game loop.");
        tickInit();
        while (isRunning) tick();
    }

    private void setUpWindow() {
        System.out.println("Setting up " + game.name + " game window.");
        renderInit();
    }
 
    /** TICK **/
    private long before;
    private long now;
    private double amountOfTicks;
    private double ns;
    private double delta;
    private boolean isRunning;
    private long timer;
    private int frames;

    private void tickInit() {
        frames = 0;
        delta = 0;
        timer = System.currentTimeMillis();
        before = System.nanoTime();
        amountOfTicks = 60.0;
        ns = 1000000000 / amountOfTicks;
        isRunning = true;
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
        // Draw.java contains class which inherits JPanel
        // Draw overrides JPanel.paint() 
        JPanel jpanel = new JPanel();
        game.getContentPane().add(jpanel);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setPreferredSize(new Dimension(400, 300));
        game.setLocationRelativeTo(null);
        game.pack();
        game.setVisible(true);
    }
}
