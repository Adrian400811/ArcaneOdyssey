import greenfoot.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Level extends World {
    protected static int totalCoins = 0;
    protected final ImgScroll scroll;
    private final int[] worldSize = {2560, 720};
    private final String background = "2dPixelForestBackground.png";
    private final Font font = new Font("Arial", 18);
    private final int level = 0;
    protected Player player;
    protected SuperDisplayLabel coinLabel = new SuperDisplayLabel(Color.BLACK, Color.WHITE, font);
    private Orb orb;

    public Level() {
        super(1280, 720, 1, false);
        scroll = new ImgScroll(this, new GreenfootImage(background), worldSize[0], worldSize[1]);
        addObject(coinLabel, 1100, 10);
        coinLabel.update("Coins: " + totalCoins);
    }

    public static void addToTotalCoin() {
        totalCoins++;
    }

    public void act() {
        scroll.scroll(getWidth() / 2 - player.getX(), getHeight() / 2 - player.getY());
    }

    public void spawnFloor() {
        for (int j = 0; j < scroll.getScrollHeight() - 100; j += 300) {
            for (int i = 0; i < scroll.getScrollWidth(); i += 106) {
                addObject(new Brick(), i, 720);
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

    public int[][] loadLevel(int level) {
        ArrayList<String> data = new ArrayList<String>();
        Scanner scan = null;
        try {
            scan = new Scanner(new File("level" + level + ".csv"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (scan.hasNextLine()) {
            data.add(scan.nextLine());
        }

        int[][] blocks = new int[120][20];
        for (String line : data) {
            StringTokenizer st = new StringTokenizer(line, ",");
            ArrayList<String> lineData = new ArrayList<String>();
            while (st.hasMoreTokens()) {
                lineData.add(st.nextToken());
            }
            blocks[Integer.parseInt(lineData.get(0))][Integer.parseInt(lineData.get(1))] = Integer.parseInt(lineData.get(2));
        }
        return blocks;
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
                    addObject(new Brick(), i * 64, j * 64);
                }
                if (identifier[i][j] == 2) {
                    addObject(orb = new Orb(), i * 64, j * 64);
                }
                if (identifier[i][j] == 3) {
                    addObject(new Coin(), i * 64, j * 64);
                }
            }
        }
    }
}
