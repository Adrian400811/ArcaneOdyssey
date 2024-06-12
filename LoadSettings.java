import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LoadSettings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LoadSettings extends World
{
    
    private Font font = new Font("Arial", 64);
    private SuperDisplayLabel titleLabel = new SuperDisplayLabel(Color.WHITE, Color.BLACK, font);
    private GreenfootImage titleImage = new GreenfootImage("ArcaneOdysseyLogo.png");
    
    private Button load1 = new Button();
    private GreenfootImage loadImage1 = new GreenfootImage("saveFile1.png");
    
    private Button load2 = new Button();
    private GreenfootImage loadImage2 = new GreenfootImage("saveFile2.png");
    

    /**
     * Constructor for objects of class LoadSettings.
     * 
     */
    public LoadSettings()
    {    
        super(1280, 720, 1); 
        
        // Background
        setBackground("WorldBackground.jpg");
        
        // Title
        addObject(titleLabel, 600, 200);
        titleLabel.setImage(titleImage);
        titleLabel.setLocation(640,150);
        
        // Load Button 1
        load1.setImage(loadImage1);
        addObject(load1, 640, 300);
        
        // Load Button 2
        load2.setImage(loadImage2);
        addObject(load2, 640, 450);
    }
    
    public void act(){
        checkPressed();
    }
    
    private void checkPressed(){
        if (Greenfoot.mouseClicked(load1)){
            
        }
        if (Greenfoot.mouseClicked(load2)){
            
        }
    }
}
