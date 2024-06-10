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
        spawnFloor();
        addObject(player = new Player(), 100, 622);
        scroll = new ImgScroll(this, new GreenfootImage(background), worldSize[0], worldSize[1]);

        // Individual Block Placement
        int[][] blockGeneration = new int[40][10];
        blockGeneration[2][5] = 1;
        spawnTerrain(blockGeneration);
    }

    public void act() {
        coinLabel.update("Coins: " + totalCoins);
        coinLabel.setLocation(getWidth()/2, 20);
        scroll.scroll(getWidth() / 2 - player.getX(), getHeight() / 2 - player.getY());
    }

    /**
     * NOTE - Use a 2d array of [40][10] for this to work as intended
     * Each value in the array represents 64x and 72y
     */
    public void spawnTerrain(int[][] identifier) {
        for (int i = 0; i < identifier.length; i++) {
            for (int j = 0; j < identifier[i].length; j++) {
                if (identifier[i][j] == 1) {
                    // i represents the X-values and j represents the y-values
                    addObject(new Brick(), i * 64, j * 72);
                }
                if (identifier[i][j] == 2) {
                    addObject(orb = new Orb(), i * 64, j * 72);
                }
            }
        }
    }
}
