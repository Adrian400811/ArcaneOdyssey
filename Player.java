import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private World w;
    private static int speed;
    public void addedToWorld(World w){
        this.w = w;
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {   
        // Movement
        if (Greenfoot.isKeyDown("D")){
            setLocation(getX()+2, getY());
            speed = 2;
        }
        if (Greenfoot.isKeyDown("A")){
            setLocation(getX()-2, getY());
            speed = -2;
        }
        // Jump
        if (Greenfoot.isKeyDown("Space") && isTouching(Block.class)){
            for (int i = 0; i < 20; i+=2){
                setLocation(getX(), getY()-i);
            }
        }
        // Fall
        if (!isTouching(Block.class)){
            setLocation(getX(), getY()+2);
        }
        // Boundary
        if(w != null){
            if (getX() < 0){
                setLocation(0,getY());
            }
            if (getX() > w.getWidth()){
                setLocation(w.getWidth(), getY());
            }
            if (getY() < 0){
                setLocation(getX(), 0);
            }
            if (getY() > w.getHeight()){
                setLocation(getX(), w.getHeight());
            }
        }
    }
    
    public static int getSpeed(){
        return speed;
    }
}
