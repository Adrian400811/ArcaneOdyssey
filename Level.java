import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.World;

public class Level extends World {
    protected final ImgScroll scroll;
    private final int[] worldSize = {2560, 720};
    private final String background = "2dPixelForestBackground.png";
    protected Player player;
    private Orb orb;

    public Level() {
        super(1280, 720, 1, false);
        scroll = new ImgScroll(this, new GreenfootImage(background), worldSize[0], worldSize[1]);
    }

    public void act() {
        scroll.scroll(getWidth() / 2 - player.getX(), getHeight() / 2 - player.getY());
    }

    public void spawnFloor() {
        for (int j = 0; j < scroll.getScrollHeight() - 100; j += 300) {
            for (int i = 0; i < scroll.getScrollWidth(); i += 106) {
                addObject(new Brick(), i, 700);
            }
        }
    }

    /**
     * NOTE - Use a 2d array of [40][10] for this to work as intended
     * Each value in the array represents 64x and 64y
     */
    public void spawnTerrain(int[][] identifier) {
        for (int i = 0; i < identifier.length; i++) {
            for (int j = 0; j < identifier[i].length; j++) {
                if (identifier[i][j] == 1) {
                    // i represents the X-values and j represents the y-values
                    addObject(new Brick(), i * 64, j * 64);
                }
                if (identifier[i][j] == 2) {
                    addObject(orb = new Orb(), i * 64, j * 64);
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

    public int[] getWorldSize() {
        return worldSize;
    }

    public int[] getMapBoundary() {
        int[] mapBoundary = new int[2];
        mapBoundary[0] = scroll.getScrolledX();
        mapBoundary[1] = scroll.getScrollWidth() + scroll.getScrolledX();
        return mapBoundary;
    }
}
