import greenfoot.Actor;
import greenfoot.GreenfootImage;

/**
 * Write a description of class Coin here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Coin extends Collection {
    private GreenfootImage image;
    
    public Coin(){
        image = new GreenfootImage("coin.png");
        image.scale(45,45);
        setImage(image);
            
    }

    /**
     * Act - do whatever the Coin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if (isTouching(Player.class)) {
            getWorld().removeObject(this);
            Level.addToTotalCoin();
        }
        
    }
}
