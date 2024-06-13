import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.GreenfootImage;
import greenfoot.World;

public class JumpBooster extends Actor {
    GreenfootImage image;

    public JumpBooster() {
        image = new GreenfootImage(64, 64);
        image.setColor(new Color(63, 81, 181, 128));
        image.fillRect(0, 0, 64, 64);
        setImage(image);
    }

    public void addedToWorld(World w) {

    }

    public void act() {
        Player p = (Player) getOneIntersectingObject(Player.class);
        if (p != null) {
            p.jumpBoost();
        }
    }
}
