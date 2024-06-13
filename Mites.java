import greenfoot.GreenfootImage;
import greenfoot.World;

/**
 * Mites Class
 * 
 * @author Adrian, Jason(graphics)
 * @version June 13 2024
 */
public class Mites extends Mobs {
    private final int hp;
    private final int dmg;
    private final int speed;
    private final GreenfootImage image;
    private int direction = 1;
    private Level w;
    private int movementAct;
    private int jumpAct;

    public Mites() {
        hp = 2;
        dmg = 1;
        speed = 2;
        image = new GreenfootImage("images/mites.png");
        image.scale(64, 43);
        setImage(image);
    }

    public void addedToWorld(World w) {
        this.w = (Level) w;
    }

    public void act() {
        movementAct--;
        jumpAct--;
        movement();
        direction = bounceWall(direction, image);
        collision();
        fall();
        attack(dmg);
    }

    private void fall() {
        if (getOneObjectAtOffset(0, (getImage().getHeight() / 2) + 1, Tile.class) == null && jumpAct < 15) {
            setLocation(getX() + (speed * direction), getY() + 5);
        }
    }

    private void movement() {
        if (movementAct < 0 && getOneObjectAtOffset(0, (getImage().getHeight() / 2) + 1, Tile.class) != null) {
            jumpAct = 30;
            movementAct = 60;
        }
        if (jumpAct > 15) {
            setLocation(getX() + (speed * direction), getY() - 5);
        }
    }
}
