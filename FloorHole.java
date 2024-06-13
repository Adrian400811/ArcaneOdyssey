import greenfoot.Actor;
import greenfoot.GreenfootImage;
import greenfoot.World;

import java.util.List;

/**
 * FloorHole class
 * 
 * @author Adrian
 * @version June 13 2024
 */
public class FloorHole extends Actor {
    public FloorHole() {
        GreenfootImage image = new GreenfootImage(1, 1);
        setImage(image);
    }

    public void addedToWorld(World w) {
        List<Brick> brick = getObjectsInRange(32, Brick.class);
        for (Brick b : brick) {
            w.removeObject(b);
        }
    }
}
