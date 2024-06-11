import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverScreen extends World
{
    private Font font = new Font("Arial", 64);
    private SuperDisplayLabel titleLabel = new SuperDisplayLabel(Color.WHITE, Color.BLACK, font);
    private GreenfootImage titleImage = new GreenfootImage("GameOverText.png");
    
    private SuperDisplayLabel gameOverLabel = new SuperDisplayLabel(font);
    private GreenfootImage gameOverImage = new GreenfootImage("gameOverInstructions.png");
    
    /**
     * Constructor for objects of class GameOverScreen.
     * 
     */
    public GameOverScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        
        // Background
        setBackground("bricks.jpg");
        
        // Title
        addObject(titleLabel, 600, 200);
        titleLabel.setImage(titleImage);
        titleLabel.setLocation(640,150);
        
        // Instruction Label
        addObject(gameOverLabel,getWidth()/2, 600);
        gameOverLabel.update("Press 'enter' to go to the Title Screen");
        gameOverImage.scale(1100, 60);
        gameOverLabel.setImage(gameOverImage);
        gameOverLabel.setLocation(getWidth()/2, 600);
        
        
    }
    
    public void act(){
        checkKeys();
    }
    
    private void checkKeys(){
        if (Greenfoot.isKeyDown("enter")){
            TitleScreen title = new TitleScreen();
            Greenfoot.setWorld(title);
        }
    }
}
