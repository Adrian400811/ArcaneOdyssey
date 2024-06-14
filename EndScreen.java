import greenfoot.*;

/**
 * End Screen for the game
 *
 * @author Jimmy
 * @version June 13 2024
 */
public class EndScreen extends World {
    /**
     * Constructor for objects of class EndScreen.
     */
    public EndScreen() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1);
        
        // Paint Order
        setPaintOrder(SuperDisplayLabel.class, Crown.class, Button.class);

        // Background
        setBackground("brick.jpg");

        // Title
        Font font = new Font("Arial", 64);
        SuperDisplayLabel titleLabel = new SuperDisplayLabel(Color.WHITE, Color.BLACK, font);
        addObject(titleLabel, 600, 200);
        GreenfootImage titleImage = new GreenfootImage("youWin.png");
        titleLabel.setImage(titleImage);
        titleLabel.setLocation(640, 150);

        // Instruction Label
        SuperDisplayLabel gameOverLabel = new SuperDisplayLabel(font);
        addObject(gameOverLabel, getWidth() / 2, 600);
        gameOverLabel.update("Press 'enter' to go to the Title Screen");
        GreenfootImage gameOverImage = new GreenfootImage("gameOverInstructions.png");
        gameOverImage.scale(1100, 60);
        gameOverLabel.setImage(gameOverImage);
        gameOverLabel.setLocation(getWidth() / 2, 600);

        // Add a Crown 
        Crown crown = new Crown();
        addObject(crown, getWidth() / 2 - 5, getHeight() / 2 - 78);

        // Add player
        GreenfootImage playerImage = new GreenfootImage("GuyR0.png");
        playerImage.scale(140, 150);
        Button player = new Button();
        player.setImage(playerImage);
        addObject(player, getWidth() / 2, getHeight() / 2);

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
