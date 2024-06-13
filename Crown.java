import greenfoot.GreenfootImage;

/**
 * Crown class
 *
 * @author Daniel
 * @version June 13 2024
 */
public class Crown extends Collection {
    private final GreenfootImage image;

    /**
     * Constructor
     */
    public Crown() {
        image = new GreenfootImage("crown.png");
        image.scale(64, 64);
        setImage(image);
    }

    /**
     * Act - Removes from world if touching Player and adds it to totalCrowns
     */
    public void act() {
        if (isTouching(Player.class)){
            playCollected();
            getWorld().removeObject(this);
            Level.addCrown();
        }
    }
}
