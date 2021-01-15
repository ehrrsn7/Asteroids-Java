/**
 * Asteroids Game file
 * 
 * This Game object houses all of the Game objects and methods.
 * Primary Methods:
 * - Update
 * - Display
 */

public class Asteroids {
    // constructor
    public Asteroids() {
        name = "Asteroids";
        System.out.println(name + " obj created.");
    }

    public void update() {
        System.out.print("Asteroids.update() ");
        display();
    }

    public void display() {
        System.out.println("Asteroids.display()");
    }

    // attributes
    public String name;
}
