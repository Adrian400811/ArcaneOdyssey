import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title Screen for the game
 * Players can create a new game 
 * Or load their previous game if they have a save file
 * 
 * @author Jimmy
 * @version June 13 2024
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
    
    private static GreenfootSound bgm = new GreenfootSound("bgm.mp3");
    
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
        
        // Background Music
        bgm.setVolume(30);
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
    
    /** Play background music if world has started */
    public void started() {
         bgm.playLoop();
    }

    /** Pause background music if world has stopped */
    public void stopped() {
        bgm.pause();
    }

    /** Method to stop background music from any world */
    public static void stopBGM() {
        bgm.pause();
    }

    /** Method to play background music from any world */
    public static void playBGM() {
        bgm.playLoop();
    }
}
