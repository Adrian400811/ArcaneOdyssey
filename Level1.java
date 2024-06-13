import greenfoot.GreenfootImage;

/**
 * Write a description of class Level1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Level1 extends Level {
    private final ImgScroll scroll;
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
        updateCoin(coinLabel);

        // Individual Block Placement
        int[][] blockGeneration = loadLevel(1);
        spawnTerrain(blockGeneration);
    }

    public void act() {
        followPlayer(scroll, player);
        updateCoin(coinLabel);
        saveButton.setLocation(getWidth()-100, 40);
        checkSaveButton();
        loseLife();
        checkNext();
    }
    
    private void loseLife(){
        if (player.touchingSpike()){
            player.changeHP(-5);
            setHP(totalHP-5);
        }
    }
}
