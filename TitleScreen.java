import greenfoot.*;

/**
 * Title Screen for the game
 * Players can create a new game
 * Or load their previous game if they have a save file
 *
 * @author Jimmy
 * @version June 13 2024
 */
public class TitleScreen extends World {
    private static final GreenfootSound bgm = new GreenfootSound("bgm.mp3");
    private final Button startNew = new Button();
    private final Button loadGame = new Button();

    /**
     * Constructor for objects of class TitleScreen.
     */
    public TitleScreen() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1);

        // Background
        setBackground("WorldBackground.jpg");

        // Title
        Font font = new Font("Arial", 64);
        SuperDisplayLabel titleLabel = new SuperDisplayLabel(Color.WHITE, Color.BLACK, font);
        addObject(titleLabel, 600, 200);
        GreenfootImage titleImage = new GreenfootImage("ArcaneOdysseyLogo.png");
        titleLabel.setImage(titleImage);
        titleLabel.setLocation(640, 150);

        // Start Button
        GreenfootImage startImage = new GreenfootImage("startNewImage.png");
        startNew.setImage(startImage);
        addObject(startNew, 640, 300);

        // Load Button
        GreenfootImage loadImage = new GreenfootImage("loadGameImage.png");
        loadGame.setImage(loadImage);
        addObject(loadGame, 640, 450);

        // Background Music
        bgm.setVolume(30);
    }

    /**
     * Method to stop background music from any world
     */
    public static void stopBGM() {
        bgm.pause();
    }

    /**
     * Method to play background music from any world
     */
    public static void playBGM() {
        bgm.playLoop();
    }

    public void act() {
        checkPressed();
    }

    public void checkPressed() {
        if (Greenfoot.mouseClicked(startNew)) {
            Level0 world = new Level0();
            Greenfoot.setWorld(world);
        }
        if (Greenfoot.mouseClicked(loadGame)) {
            LoadSettings world = new LoadSettings();
            Greenfoot.setWorld(world);
        }
    }

    /**
     * Play background music if world has started
     */
    public void started() {
        bgm.playLoop();
    }

    /**
     * Pause background music if world has stopped
     */
    public void stopped() {
        bgm.pause();
    }
}
