import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private static int speed;
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.isKeyDown("D")){
            setLocation(getX()+2, getY());
            speed = 2;
        } if (Greenfoot.isKeyDown("A")){
            setLocation(getX()-2, getY());
            speed = -2;
        } if (Greenfoot.isKeyDown("Space") && isTouching(Brick.class)){
            for (int i = 0; i < 20; i+=2){
                setLocation(getX(), getY()-i);
            }
        } if (!isTouching(Brick.class)){
            setLocation(getX(), getY()+2);
        } if (getX() < 0){
            setLocation(0,getY());
        } if (getX() > 2560){
            setLocation(2560, getY());
        } if (getY() < 0){
            setLocation(getX(), 0);
        } if (getY() > 720){
            setLocation(getX(), 720);
        }
    }
    
    public static int getSpeed(){
        return speed;
    }
}
