import greenfoot.Actor;

/**
 * Write a description of class Orb here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Orb extends Actor {
    /**
     * Act - do whatever the Orb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        // Add your action code here.
    }

    public boolean isBeingTouched() {
        return isTouching(Player.class);
    }
}
