import greenfoot.GreenfootImage;

/**
 * Coin class
 *
 * @author Jimmy, Daniel
 * @version June 13 2024
 */
public class Coin extends Collection {
    private final GreenfootImage image;

    /**
     * Constructor
     */
    public Coin() {
        image = new GreenfootImage("coin.png");
        image.scale(45,45);
        setImage(image);

    }

    /**
     * Act - if touching Player, remove coin and add it to the total coins
     */
    public void act() {
        if (isTouching(Player.class)) {
            getWorld().removeObject(this);
            Level.addToTotalCoin();
        }
    }
}
