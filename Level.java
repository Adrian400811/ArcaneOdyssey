import greenfoot.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Level extends World {
    protected static int totalCoins = 0;
    protected static int totalHP = 5;
    protected static int numOfCrown=0;
    private final int[] worldSize = {2560, 720};
    private final String background = "2dPixelForestBackground.png";
    private final Font font = new Font("Arial", 18);
    private int level = 0;
    protected ImgScroll scroll;
    protected Player player;
    protected SuperDisplayLabel coinLabel = new SuperDisplayLabel(Color.BLACK, Color.WHITE, font);
    private Orb orb;
    protected Button saveButton = new Button();
    private GreenfootImage saveButtonImage = new GreenfootImage ("saveButtonImage.png");
    

    public Level() {
        super(1280, 720, 1, false);
        saveButtonImage.scale(150, 60);
        saveButton.setImage(saveButtonImage);
    }
    
    public static void resetCoin() {
        totalCoins = 0;
    }

    public static void addToTotalCoin() {
        totalCoins++;
    }
    public static void addCrown(){
        numOfCrown++;
    }
    public void spawnFloor(ImgScroll sc) {
        for (int j = 0; j < sc.getScrollHeight() - 100; j += 300) {
            for (int i = 0; i < sc.getScrollWidth() + 64; i += 63) {
                addObject(new Brick(), i, 700);
            }
        }
    }

    public void checkNext() {
        if (orb.isBeingTouched()) {
            levelUp();
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
    
    public void followPlayer(ImgScroll scr, Player p) {
        if (p != null) {
            scr.scroll(getWidth() / 2 - p.getX(), getHeight() / 2 - p.getY());
        }
    }

    public void updateCoin(SuperDisplayLabel cl) {
        cl.update("Coins: " + totalCoins + "     HP: " + totalHP);
        cl.setLocation(getWidth() / 2, 20);
    }

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
     * NOTE - Use a 2d array of [40][10] for this to work as intended
     * Each value in the array represents 64x and 72y
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
                    default -> null;
                };
                if (a != null) {
                    addObject(a, i * 64, j * 64);
                }
            }
        }
    }
    
    public void checkToSave(){
        try{
            FileWriter out = new FileWriter("saveFile1.csv");
            PrintWriter output = new PrintWriter(out);
            output.println(totalHP + "," + totalCoins + "," + level);
            //output.println(totalCoins + ",");
            //output.println(level);
            output.close();
        } catch (IOException e) {
            
        }
    }
    
    public void checkSaveButton(){
        if (Greenfoot.mouseClicked(saveButton)){
            checkToSave();
        }
    }
    
    public void levelUp(){
        level++;
    }
    
    public void setHP(int hp){
        totalHP = hp;
    }
    
    public void setCoins(int coins){
        totalCoins = coins;
    }
}

