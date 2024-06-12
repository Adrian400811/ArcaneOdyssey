import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.World;

/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player extends Actor {
    private static int speed;
    private final int dmg;
    private int hp;
    private World w;
    private int jumpActs = 0;

    public Player() {
        hp = 5;
        dmg = 1;
    }

    public void addedToWorld(World w) {
        this.w = w;
    }

    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        jumpActs--;
        movement();
        jump();
        fall();
        collision();
        boundary();
        checkHP();
    }

    private void movement() {
        if (Greenfoot.isKeyDown("D")) {
            setLocation(getX() + 8, getY());
            speed = 8;
        }
        if (Greenfoot.isKeyDown("A")) {
            setLocation(getX() - 8, getY());
            speed = -8;
        }
    }

    private void jump() {
        if (Greenfoot.isKeyDown("Space") && getOneObjectAtOffset(0, (getImage().getHeight() / 2) + 1, Brick.class) != null) {
            jumpActs = 30;
        }
        if (jumpActs > 15) {
            setLocation(getX(), getY() - 8);
        }
    }

    private void fall() {
        if (getOneObjectAtOffset(0, (getImage().getHeight() / 2) + 1, Brick.class) == null && jumpActs < 15) {
            setLocation(getX(), getY() + 8);
        }
    }

    private void boundary() {
        if (w == null) {
            return;
        }
        if (getX() < 0) {
            setLocation(0, getY());
        }
        if (getX() > w.getWidth()) {
            setLocation(w.getWidth(), getY());
        }
        if (getY() < 0) {
            setLocation(getX(), 0);
        }
        if (getY() > w.getHeight()) {
            setLocation(getX(), 0);
        }
    }

    private void collision() {
        if (getOneObjectAtOffset(getImage().getWidth() / 2, 0, Brick.class) != null) {
            setLocation(getX() - speed, getY());
        }
        if (getOneObjectAtOffset(-(getImage().getWidth() / 2), 0, Brick.class) != null) {
            setLocation(getX() - speed, getY());
        }
        if (getOneObjectAtOffset(0, -(getImage().getHeight() / 2), Brick.class) != null) {
            setLocation(getX(), getY() + 6);
            jumpActs = 0;
        }
        if (getOneObjectAtOffset(0, (getImage().getHeight() / 2), Brick.class) != null) {
            setLocation(getX(), getY() - 1);
            jumpActs = 0;
        }
    }

    private void checkHP() {
        if (hp > 0) {
            return;
        }
        w.removeObject(this);
    }

    public int getSpeed() {
        return speed;
    }

    public void changeHP(int deltaHP) {
        hp += deltaHP;
    }
}
