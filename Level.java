import greenfoot.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
 * Level Superclass
 * 
 * @author Adrian, Jimmy
 * @version June 13, 2024
 */

public class Level extends World {
    protected static int totalCoins = 0;
    protected static int totalHP = 5;
    protected static int numOfCrown = 0;
    private static int level = 0;
    private final int[] worldSize = {2560, 720};
    private final String background = "2dPixelForestBackground.png";
    private final Font font = new Font("Arial", 18);
    private final GreenfootImage saveButtonImage = new GreenfootImage("saveButtonImage.png");
    protected ImgScroll scroll;
    protected Player player;
    protected SuperDisplayLabel coinLabel = new SuperDisplayLabel(Color.BLACK, Color.WHITE, font);
    protected Button saveButton = new Button();
    private Orb orb;

    /**
     * Constructor
     */
    public Level() {
        super(1280, 720, 1, false);
        saveButtonImage.scale(150, 60);
        saveButton.setImage(saveButtonImage);
        setPaintOrder(Button.class, SuperDisplayLabel.class, Tile.class);
    }
    
    /**
     * Constructor
     * 
     * @param int   The level to go to
     */
    public Level(int level) {
        super(1280, 720, 1, false);
        saveButtonImage.scale(150, 60);
        saveButton.setImage(saveButtonImage);
        setPaintOrder(Button.class, SuperDisplayLabel.class, Tile.class);
        setLevel(level);
    }

    /**
     * Resets coins
     */
    public static void resetCoin() {
        totalCoins = 0;
    }

    /**
     * Adds a singular coin to the total
     */
    public static void addToTotalCoin() {
        totalCoins++;
    }

    /**
     * Adds one crown to the total
     */
    public static void addCrown() {
        numOfCrown++;
    }

    /**
     * Spawns the floor of the world
     */
    public void spawnFloor(ImgScroll sc) {
        for (int i = 0; i < sc.getScrollWidth() + 64; i += 64) {
            addObject(new Brick(), i, 700);
        }
    }

    /**
     * Check if touching Orb.
     * If it is touching orb, go to the next level
     */
    public void checkNext() {
        if (orb.isBeingTouched()) {
            if (level == 0) {
                levelUp();
                Level1 world = new Level1();
                Greenfoot.setWorld(world);
                return;
            }
            if (level == 1) {
                EndScreen end = new EndScreen();
                Greenfoot.setWorld(end);
            }
        }
    }

    /**
     * Sets the current level to the desired level
     * 
     * @param int     The desired level to go to
     */
    public void setLevel(int level) {
        Level.level = level;
    }

    /**
     * Returns the size of the world
     * 
     * @return int[]    the size of the world
     */
    public int[] getWorldSize() {
        return worldSize;
    }

    /**
     * Returns the boundaries of the map
     * 
     * @return int[]    the boundary of the map
     */
    public int[] getMapBoundary() {
        int[] mapBoundary = new int[2];
        mapBoundary[0] = scroll.getScrolledX();
        mapBoundary[1] = scroll.getScrollWidth() + scroll.getScrolledX();
        return mapBoundary;
    }

    /**
     * Follows the Player around the map
     */
    public void followPlayer(ImgScroll scr, Player p) {
        if (p != null) {
            scr.scroll(getWidth() / 2 - p.getX(), getHeight() / 2 - p.getY());
        }
    }


    /**
     * Updates the coin and hp and sets the location of it
     * 
     * @param SuperDisplayLabel   the label to update
     */
    public void updateCoin(SuperDisplayLabel cl) {
        cl.update("Coins: " + totalCoins + "     HP: " + totalHP);
        cl.setLocation(getWidth() / 2, 20);
    }
    
    public void updateCoin() {
        coinLabel.update("Coins: " + totalCoins + "     HP: " + totalHP);
        coinLabel.setLocation(getWidth() / 2, 20);
    }

    /**
     * Loads level from a csv file
     * 
     * @param level     The level to load
     * @return int[][]  The 2d array with the location of the blocks
     */
    public int[][] loadLevel(int level) {
        ArrayList<String> data = new ArrayList<String>();
        Scanner scan = null;
        try {
            scan = new Scanner(new File("levels/" + level + ".csv"));
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
     * Spawns the blocks
     * 
     * @param identifier    The 2d array of blocks to be loaded
     * 
     * 
     * NOTE - Use a 2d array of [40][10] for this to work as intended
     * Each value in the array represents 64x and 64y
     */
    public void spawnTerrain(int[][] identifier) {
        for (int i = 0; i < identifier.length; i++) {
            for (int j = 0; j < identifier[i].length; j++) {
                Actor a = switch (identifier[i][j]) {
                    case 1 -> new Brick();
                    case 2 -> orb = new Orb();
                    case 3 -> new Coin();
                    case 4 -> new Mites();
                    case 5 -> new BlueBee();
                    case 6 -> new RedBee();
                    case 7 -> new GreenBee();
                    case 8 -> new Spider();
                    case 9 -> new Crown();
                    case 10 -> new JumpBooster();
                    case 11 -> new Spike();
                    case 12 -> new FloorHole();
                    default -> null;
                };
                if (a != null) {
                    addObject(a, i * 64, j * 64);
                }
            }
        }
    }

    /**
     * Saves the values to a csv file
     */
    public void checkToSave() {
        try {
            FileWriter out = new FileWriter("saveFile1.csv");
            PrintWriter output = new PrintWriter(out);
            output.println(totalHP + "," + totalCoins + "," + level);
            output.close();
        } catch (IOException e) {

        }
    }

    /**
     * Checks if saveButton has been clicked
     * If clicked, runs the checkToSave() method
     */
    public void checkSaveButton() {
        if (Greenfoot.mouseClicked(saveButton)) {
            checkToSave();
        }
    }

    /**
     * Increases level by one
     */
    public void levelUp() {
        level++;
    }

    /**
     * Sets current HP to desired HP
     * 
     * @param hp        The desired HP
     */
    public void setHP(int hp) {
        totalHP = hp;
    }
    
    /**
     * Sets coins to the desired coins
     * 
     * @param coins     The desired coins
     */
    public void setCoins(int coins) {
        totalCoins = coins;
    }
}

