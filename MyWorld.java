import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyWorld extends World {
    private final ImgScroll scroll;
    private final Player player;
    private int[][] blockGeneration;
    private Orb orb;

    /**
     * Constructor for objects of class MyWorld.
     */
    public MyWorld() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1, false);
        addObject(player = new Player(), 100, 622);
        scroll = new ImgScroll(this, new GreenfootImage("2dPixelForestBackground.png"), 2560, 720);
        // Flooring
        for (int j=0; j<scroll.getScrollHeight()-100; j+=300){
            for (int i=0; i<scroll.getScrollWidth(); i+=106){
                addObject(new Brick(), 0+i, 700);
            }
        }
        // Individual Block Placement
        blockGeneration = new int[40][10];
        blockGeneration[10][5] = 1;
        blockGeneration[11][5] = 1;
        blockGeneration[12][5] = 1;
        blockGeneration[28][5] = 1;
        blockGeneration[10][6] = 2;
        blockGeneration[10][9] = 1;
        blockGeneration[10][9] = 1;
        blockGeneration[5][7] = 1;
        spawnTerrain(blockGeneration);
    }


    public void act() {
        scroll.scroll(getWidth() / 2 - player.getX(), getHeight() / 2 - player.getY());
        checkNext();
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

    public void checkNext() {
        if (orb.isBeingTouched()) {
            Level1 world = new Level1();
            Greenfoot.setWorld(world);
        }
    }
}
