import greenfoot.GreenfootImage;
import greenfoot.World;

public class Mites extends Mobs {
    private final int hp;
    private final int dmg;
    private final int speed;
    private final int direction = 1;
    private final GreenfootImage image;
    private Level w;
    private int movementAct;
    private int jumpAct;

    public Mites() {
        hp = 2;
        dmg = 1;
        speed = 2;
        image = new GreenfootImage("images/mites.png");
    }

    public void addedToWorld(World w) {
        this.w = (Level) w;
    }

    public void act() {
        movementAct--;
        jumpAct--;
        movement();
        bounceWall();
        collision();
        fall();
    }

    private void flipImage() {
        image.mirrorHorizontally();
    }

    private void fall() {
        if (getOneObjectAtOffset(0, (getImage().getHeight() / 2) + 1, Brick.class) == null && jumpAct < 15) {
            setLocation(getX() + (speed * direction), getY() + 5);
        }
    }

    private void movement() {
        if (movementAct < 0 && getOneObjectAtOffset(0, (getImage().getHeight() / 2) + 1, Brick.class) != null) {
            jumpAct = 30;
            movementAct = 60;
        }
        if (jumpAct > 15) {
            setLocation(getX() + (speed * direction), getY() - 5);
        }
    }
}
