import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    private Font font = new Font("Arial", 64);
    private SuperDisplayLabel titleLabel = new SuperDisplayLabel(Color.WHITE, Color.BLACK, font);
    private GreenfootImage titleImage = new GreenfootImage("ArcaneOdysseyLogo.png");
    
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280,720, 1); 
        addObject(titleLabel, 600, 200);
        titleLabel.setImage(titleImage);
        titleLabel.setLocation(640,150);
    }
}
