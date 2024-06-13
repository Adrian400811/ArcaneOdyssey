import greenfoot.GreenfootImage;

/**
 * Write a description of class Block here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Brick extends Tile {
    public Brick() {
        GreenfootImage image = new GreenfootImage("brick.jpg");
        image.scale(64, 64);
        setImage(image);
    }

    /**
     * Act - do whatever the Block wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
    }
}
