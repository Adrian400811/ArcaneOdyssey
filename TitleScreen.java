import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title Screen 
 * 
 * @author Jimmy
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    private Font font = new Font("Arial", 64);
    private SuperDisplayLabel titleLabel = new SuperDisplayLabel(Color.WHITE, Color.BLACK, font);
    private GreenfootImage titleImage = new GreenfootImage("ArcaneOdysseyLogo.png");
    
    private Button startNew = new Button();
    private GreenfootImage startImage = new GreenfootImage("startNewImage.png");
    
    private Button loadGame = new Button();
    private GreenfootImage loadImage = new GreenfootImage("loadGameImage.png");
    
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280,720, 1); 
        
        // Background
        setBackground("WorldBackground.jpg");
        
        // Title
        addObject(titleLabel, 600, 200);
        titleLabel.setImage(titleImage);
        titleLabel.setLocation(640,150);
        
        // Start Button
        startNew.setImage(startImage);
        addObject(startNew, 640, 300);
        
        // Load Button
        loadGame.setImage(loadImage);
        addObject(loadGame, 640, 450);
    }
    
    public void act(){
        checkPressed();
    }
    
    public void checkPressed(){
        if (Greenfoot.mouseClicked(startNew)){
            Level0 world = new Level0();
            Greenfoot.setWorld(world);
        }
        if (Greenfoot.mouseClicked(loadGame)){
            LoadSettings world = new LoadSettings();
            Greenfoot.setWorld(world);
        }
    }
}
