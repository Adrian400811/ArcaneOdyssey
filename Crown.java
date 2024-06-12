import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Crown here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Crown extends Collection
{
    /**
     * Act - do whatever the Crown wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (isTouching(Player.class)){
            getWorld().removeObject(this);
            Level.addCrown();
        }
    }
}
