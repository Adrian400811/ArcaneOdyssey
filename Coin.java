import greenfoot.GreenfootImage;

/**
 * Coin class
 *
 * @author Jimmy, Daniel
 * @version June 13 2024
 */
public class Coin extends Collection {

    /**
     * Constructor
     */
    public Coin() {
        GreenfootImage image = new GreenfootImage("coin.png");
        image.scale(45, 45);
        setImage(image);

    }

    /**
     * Act - if touching Player, remove coin and add it to the total coins
     */
    public void act() {
        if (isTouching(Player.class)) {
            playCollected();
            getWorld().removeObject(this);
            Level.addToTotalCoin();
        }
    }
}
