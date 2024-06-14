import greenfoot.*;

/**
 * Screen for when Player dies
 *
 * @author Jimmy
 * @version June 13 2024
 */
public class GameOverScreen extends World {
    private final Font font = new Font("Arial", 64);
    private final SuperDisplayLabel titleLabel = new SuperDisplayLabel(Color.WHITE, Color.BLACK, font);
    private final GreenfootImage titleImage = new GreenfootImage("GameOverText.png");

    private final SuperDisplayLabel gameOverLabel = new SuperDisplayLabel(font);
    private final GreenfootImage gameOverImage = new GreenfootImage("gameOverInstructions.png");

    private GreenfootImage playerImage = new GreenfootImage("GuyDeath.png");
    private Button player = new Button();
    
    /**
     * Constructor for objects of class GameOverScreen.
     */
    public GameOverScreen() {
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

        //Add player
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
