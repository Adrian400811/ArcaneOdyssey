import greenfoot.GreenfootImage;

/**
 * Write a description of class Crown here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Crown extends Collection {
    private final GreenfootImage image;

    public Crown() {
        image = new GreenfootImage("crown.png");
        image.scale(64, 64);
        setImage(image);
    }

    /**
     * Act - do whatever the Crown wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        // Add your action code here.
    }
}
