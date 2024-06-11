import greenfoot.GreenfootImage;

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
    private Orb orb;

    /**
     * Constructor for objects of class Level0.
     */
    public Level0() {
        super();
        spawnFloor();
        addObject(player = new Player(), 100, 622);
        String background = "2dPixelForestBackground.png";
        scroll = new ImgScroll(this, new GreenfootImage(background), worldSize[0], worldSize[1]);

        int[][] blockGeneration = loadLevel(0);
        spawnTerrain(blockGeneration);
        addObject(new BlueBee(), 800, 600);
        addObject(new RedBee(), 100, 600);
        addObject(new Spider(), 750, 600);
        addObject(new Mites(), 150, 600);
    }

    public void act() {
        coinLabel.update("Coins: " + totalCoins);
        coinLabel.setLocation(getWidth() / 2, 20);
        scroll.scroll(getWidth() / 2 - player.getX(), getHeight() / 2 - player.getY());
        checkNext();
    }
}
