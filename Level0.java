import greenfoot.GreenfootImage;
import greenfoot.*;

/**
 * Write a description of class Level0 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Level0 extends Level {
    private final ImgScroll scroll;
    private final Player player;
    private final int[] worldSize = {2560, 720};
    private final String background = "2dPixelForestBackground.png";
    private Orb orb;
    
    /**
     * Constructor for objects of class Level0.
     */
    public Level0() {
        super();
        spawnFloor();
        addObject(player = new Player(), 100, 622);
        scroll = new ImgScroll(this, new GreenfootImage(background), worldSize[0], worldSize[1]);

        int[][] blockGeneration = new int[40][10];
        blockGeneration[10][5] = 1;
        blockGeneration[11][5] = 1;
        blockGeneration[12][5] = 1;
        blockGeneration[28][5] = 1;
        blockGeneration[10][6] = 2;
        blockGeneration[10][9] = 1;
        blockGeneration[5][7] = 1;
        blockGeneration[5][8] = 3;
        spawnTerrain(blockGeneration);
        

        int[][] mobGeneration = new int[40][10];
        addObject(new BlueBee(), 800, 600);
        addObject(new RedBee(), 100, 600);
        addObject(new Spider(), 1200, 600);
    }

    public void act() {
        coinLabel.update("Coins: " + totalCoins);
        scroll.scroll(getWidth() / 2 - player.getX(), getHeight() / 2 - player.getY());
        checkNext();
    }

    public void loadLevel() {
        // placeholder if we ever store map data in csv
    }
}
