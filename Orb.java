import greenfoot.Actor;

/**
 * Orb class
 *
 * @author Jimmy
 * @version June 13 2024
 */
public class Orb extends Actor {
    /**
     * Act - do whatever the Orb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        // Add your action code here.
    }
    
    /**
     * Returns true if Orb is touching Player Class
     * Returns false if Orb is not touching Player Class
     * 
     */
    public boolean isBeingTouched() {
        return isTouching(Player.class);
    }
}
