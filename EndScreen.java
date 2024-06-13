import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScreen extends World
{
    private final Font font = new Font("Arial", 64);
    private final SuperDisplayLabel titleLabel = new SuperDisplayLabel(Color.WHITE, Color.BLACK, font);
    private final GreenfootImage titleImage = new GreenfootImage("youWin.png");

    private final SuperDisplayLabel gameOverLabel = new SuperDisplayLabel(font);
    private final GreenfootImage gameOverImage = new GreenfootImage("gameOverInstructions.png");

    private Crown crown = new Crown();
    /**
     * Constructor for objects of class EndScreen.
     * 
     */
    public EndScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1);

        // Background
        setBackground("brick.jpg");
        
        // Title
        addObject(titleLabel, 600, 200);
        titleLabel.setImage(titleImage);
        titleLabel.setLocation(640, 150);
        
        // Instruction Label
        addObject(gameOverLabel, getWidth() / 2, 600);
        gameOverLabel.update("Press 'enter' to go to the Title Screen");
        gameOverImage.scale(1100, 60);
        gameOverLabel.setImage(gameOverImage);
        gameOverLabel.setLocation(getWidth() / 2, 600);
        
        // Add a Crown 
        addObject(crown, getWidth()/2, getHeight()/2);

    }
    
    public void act() {
        checkKeys();
    }

    private void checkKeys() {
        if (Greenfoot.isKeyDown("enter")) {
            TitleScreen title = new TitleScreen();
            Greenfoot.setWorld(title);
        }
    }
}
