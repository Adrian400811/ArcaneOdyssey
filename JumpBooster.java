import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.GreenfootImage;
import greenfoot.World;

public class JumpBooster extends Actor {
    GreenfootImage image;

    public JumpBooster() {
        image = new GreenfootImage(64, 64);
    }

    public void addedToWorld(World w) {
        image.setColor(new Color(63, 81, 181, 50));
        image.drawRect(getX(), getY() + 30, 32, 2);
        setImage(image);
    }

    public void act() {
        Player p = (Player) getOneIntersectingObject(Player.class);
        if (p != null) {
            p.jumpBoost();
        }
    }
}
