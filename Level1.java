import greenfoot.GreenfootImage;

/**
 * World for Level1 of the game
 *
 * @author Jimmy
 * @version June 13 2024
 */
public class Level1 extends Level {
    private final Player player;
    private final int[] worldSize = {2700, 720};
    private final String background = "2dSpaceBackground.png";
    private Orb orb;

    /**
     * Constructor for objects of class Level1.
     */
    public Level1() {
        super();
        scroll = new ImgScroll(this, new GreenfootImage(background), worldSize[0], worldSize[1]);
        spawnFloor(scroll);
        addObject(player = new Player(), 130, 135);
        addObject(coinLabel, 1100, 10);
        addObject(saveButton, getWidth() - 100, 40);
        updateCoin();

        // Individual Block Placement
        int[][] blockGeneration = loadLevel(1);
        spawnTerrain(blockGeneration);
    }

    public void act() {
        followPlayer(player);
        updateCoin();
        saveButton.setLocation(getWidth() - 100, 40);
        checkSaveButton();
        loseLife();
        checkNext();
    }

    private void loseLife() {
        if (player.touchingSpike()) {
            player.changeHP(-5);
            setHP(totalHP - 5);
        }
    }

    public void stopped() {
        TitleScreen.stopBGM();
    }

    public void started() {
        TitleScreen.playBGM();
    }
}
