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
    private final int[] worldSize = {2560, 720};
    private final String background = "2dSpaceBackground.png";
    private Orb orb;

    /**
     * Constructor for objects of class Level1.
     */
    public Level1() {
        super();
        scroll = new ImgScroll(this, new GreenfootImage(background), worldSize[0], worldSize[1]);
        spawnFloor(scroll);
        addObject(player = new Player(), 100, 622);
        addObject(coinLabel, 1100, 10);
        coinLabel.update("Coins: " + totalCoins);

        // Individual Block Placement
        int[][] blockGeneration = new int[40][10];
        blockGeneration[2][5] = 1;
        spawnTerrain(blockGeneration);
    }

    public void act() {
        coinLabel.update("Coins: " + totalCoins);
        coinLabel.setLocation(getWidth() / 2, 20);
        scroll.scroll(getWidth() / 2 - player.getX(), getHeight() / 2 - player.getY());
    }
}
