import greenfoot.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Load Screen for when people want to load their progress (coins,hp,level)
 *
 * @author Jimmy
 * @version June 13 2024
 */
public class LoadSettings extends World {
    private final Button load1 = new Button();

    /**
     * Constructor for objects of class LoadSettings.
     */
    public LoadSettings() {
        super(1280, 720, 1);

        // Background
        setBackground("WorldBackground.jpg");

        // Title
        Font font = new Font("Arial", 64);
        SuperDisplayLabel titleLabel = new SuperDisplayLabel(Color.WHITE, Color.BLACK, font);
        addObject(titleLabel, 600, 200);
        GreenfootImage titleImage = new GreenfootImage("ArcaneOdysseyLogo.png");
        titleLabel.setImage(titleImage);
        titleLabel.setLocation(640, 150);

        // Load Button 1
        GreenfootImage loadImage1 = new GreenfootImage("saveFile1.png");
        load1.setImage(loadImage1);
        addObject(load1, 640, 300);
    }

    public void act() {
        checkPressed();
    }

    private void checkPressed() {
        if (Greenfoot.mouseClicked(load1)) {
            int[] savedOptions = loadSave();
            int savedHP = savedOptions[0];
            int savedCoins = savedOptions[1];
            int savedLevel = savedOptions[2];

            if (savedLevel == 0) {
                Level0 level = new Level0();
                Greenfoot.setWorld(level);
                level.setHP(savedHP);
                level.setCoins(savedCoins);
            }
            if (savedLevel == 1) {
                Level1 level = new Level1();
                Greenfoot.setWorld(level);
                level.setHP(savedHP);
                level.setCoins(savedCoins);
            }

        }
    }

    public int[] loadSave() {
        ArrayList<String> data = new ArrayList<String>();
        Scanner scan = null;
        try {
            scan = new Scanner(new File("saveFile1.csv"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (scan.hasNextLine()) {
            data.add(scan.nextLine());
        }

        int[] options = new int[3];
        for (String line : data) {
            StringTokenizer st = new StringTokenizer(line, ",");
            ArrayList<String> lineData = new ArrayList<String>();
            while (st.hasMoreTokens()) {
                lineData.add(st.nextToken());
            }
            options[0] = (Integer.parseInt(lineData.get(0))); // totalHP
            options[1] = (Integer.parseInt(lineData.get(1))); // totalCoins
            options[2] = (Integer.parseInt(lineData.get(2))); // level
        }
        return options;
    }

    public void stopped() {
        TitleScreen.stopBGM();
    }

    public void started() {
        TitleScreen.playBGM();
    }
}
