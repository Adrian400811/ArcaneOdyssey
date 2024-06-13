import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * End Screen for the game
 * 
 * @author Jimmy
 * @version June 13 2024
 */
public class EndScreen extends World
{
    private final Font font = new Font("Arial", 64);
    private final SuperDisplayLabel titleLabel = new SuperDisplayLabel(Color.WHITE, Color.BLACK, font);
    private final GreenfootImage titleImage = new GreenfootImage("youWin.png");

    private final SuperDisplayLabel gameOverLabel = new SuperDisplayLabel(font);
    private final GreenfootImage gameOverImage = new GreenfootImage("gameOverInstructions.png");

    private Crown crown = new Crown();
    
    private GreenfootImage playerImage = new GreenfootImage("GuyR0.png");
    private Button player = new Button();
    
    /**
     * Constructor for objects of class EndScreen.
     * 
     */
    public EndScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1);
        
        
        // Paint Order
        setPaintOrder(SuperDisplayLabel.class, Crown.class, Button.class);

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
        addObject(crown, getWidth()/2-5, getHeight()/2-78);
        
        // Add player
        playerImage.scale(140,150);
        player.setImage(playerImage);
        addObject(player, getWidth()/2, getHeight()/2);

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
    
    public void stopped() {
        TitleScreen.stopBGM();
    }

    public void started() {
        TitleScreen.playBGM();
    }
}
