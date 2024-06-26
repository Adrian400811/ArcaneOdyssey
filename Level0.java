import greenfoot.GreenfootImage;

/**
 * World for Level0 of the game
 *
 * @author Adrian
 * @version June 13 2024
 */
public class Level0 extends Level {
    private final Player player;

    /**
     * Constructor for objects of class Level0.
     */
    public Level0() {
        super();
        String background = "2dPixelForestBackground.png";
        int[] worldSize = {7680, 720};
        scroll = new ImgScroll(this, new GreenfootImage(background), worldSize[0], worldSize[1]);
        spawnFloor(scroll);
        addObject(player = new Player(), 100, 622);
        addObject(coinLabel, 1100, 10);
        addObject(saveButton, getWidth() - 100, 40);
        updateCoin();
        resetCoin();
        setHP(5);
        setLevel(0);

        int[][] blockGeneration = loadLevel(0);
        spawnTerrain(blockGeneration);
    }

    public void act() {
        followPlayer(player);
        updateCoin();
        saveButton.setLocation(getWidth() - 100, 40);
        checkSaveButton();
        checkNext();
    }

    public void stopped() {
        TitleScreen.stopBGM();
    }

    public void started() {
        TitleScreen.playBGM();
    }
}
