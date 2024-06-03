import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.World;

/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player extends Actor {
    private static int speed;
    private World w;
    private int jumpActs = 0;

    public static int getSpeed() {
        return speed;
    }

    public void addedToWorld(World w) {
        this.w = w;
    }

    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        jumpActs--;
        // Movement
        if (Greenfoot.isKeyDown("D")) {
            setLocation(getX() + 2, getY());
            speed = 2;
        }
        if (Greenfoot.isKeyDown("A")) {
            setLocation(getX() - 2, getY());
            speed = -2;
        }
        // Jump
        if (Greenfoot.isKeyDown("Space") && isTouching(Brick.class)) {
            jumpActs = 30;
        }
        if (jumpActs > 15) {
            setLocation(getX(), getY() - 10);
        }
        // Gravity
        if (!isTouching(Brick.class)) {
            setLocation(getX(), getY() + 2);
        }
        // Boundary
        if (w != null) {
            if (getX() < 0) {
                setLocation(0, getY());
            }
            if (getX() > w.getWidth()) {
                setLocation(w.getWidth(), getY());
            }
            if (getY() < 0) {
                setLocation(getX(), 0);
            }
            if (getY() > w.getHeight()) {
                setLocation(getX(), w.getHeight());
            }
        }
    }

    public int[] getLocation() {
        int[] location = new int[2];
        location[0] = getX();
        location[1] = getY();
        return location;
    }
}
