import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin extends Actor
{
    private GreenfootImage image;
    
    public Coin(){
        image = new GreenfootImage("marioCoin.png");
        image.scale(45,55);
        setImage(image);
    }
    
    /**
     * Act - do whatever the Coin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (isTouching(Player.class)){
            getWorld().removeObject(this);
            Level.addToTotalCoin();
        }
    }
    
    public boolean isBeingTouched(){
        if (isTouching(Player.class)){
            return true;
        }
        return false;
    }
}
