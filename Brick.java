import greenfoot.GreenfootImage;

/**
 * Block Class
 *
 * @author Adrian, Jimmy
 * @version June 13 2024
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
