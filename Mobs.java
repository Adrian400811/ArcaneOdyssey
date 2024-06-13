import greenfoot.GreenfootImage;
import greenfoot.World;

import java.util.List;

/**
 * Mobs Class
 * 
 * @author Adrian, Jason
 * @version June 13 2024
 */

public abstract class Mobs extends SuperSmoothMover {
    public World w;
    private int hp;
    private int speed = 2;
    private int dmg;
    private int direction = 1;

    /**
     * Constructor
     */
    public Mobs() {
        enableStaticRotation();
    }

    public void addedToWorld(World w) {
        this.w = w;
    }

    public void act() {
        stepped();
    }

    private void gravity() {
        if (!isTouching(Brick.class)) {
            setLocation(getX(), getY() + 2);
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
            setLocation(getX(), w.getHeight());
        }
    }

    /**
     * Checks for collision with the Brick class
     */
    public void collision() {
        if (getOneObjectAtOffset(getImage().getWidth() / 2, 0, Brick.class) != null) {
            setLocation(getX() - speed, getY());
        }
        if (getOneObjectAtOffset(-(getImage().getWidth() / 2), 0, Brick.class) != null) {
            setLocation(getX() + speed, getY());
        }
    }

    protected int bounceWall(int dir) {
        if (getOneObjectAtOffset(dir * getImage().getWidth() + 1, 0, Tile.class) != null) {
            dir *= -1;
        }
        return dir;
    }

    protected int bounceWall(int dir, GreenfootImage image) {
        if (getOneObjectAtOffset(dir * getImage().getWidth() + 2, 0, Tile.class) != null) {
            dir *= -1;
            image.mirrorHorizontally();
        }
        return dir;
    }

    protected void idle() {
        if (getWorld() == null) {
            return;
        }
        turnTowards(getX() + direction, getY());
        if (getOneObjectAtOffset(direction * getImage().getWidth() + 1, 0, Brick.class) != null) {
            direction *= -1;
        } else {
            move(speed);
        }
    }

    /**
     * Get distance to a given Player
     * Inspired by Gevater_Tod4177 on greenfoot.org
     * <a href="https://www.greenfoot.org/topics/4911">...</a>
     *
     * @param p Player
     */
    public double getDistance(Player p) {
        if (p != null) {
            return Math.hypot(p.getX() - getX(), p.getY() - getY());
        }
        return 0;
    }

    /**
     * Get the Player
     * Inspired by Gevater_Tod4177 on greenfoot.org
     * <a href="https://www.greenfoot.org/topics/4911">...</a>
     */
    public Player getPlayer(int range) {
        if (getWorld() == null) {
            return null;
        }
        List<Player> pNear = getObjectsInRange(range, Player.class);
        if (!pNear.isEmpty()) {
            return pNear.get(0);
        }
        return null;
    }

    /**
     * If stepped on by Player class, remove this mob
     */
    public void stepped() {
        if (getWorld() == null) {
            return;
        }
        if (getOneObjectAtOffset(getX(), -(getImage().getHeight() / 2), Player.class) != null) {
            getWorld().removeObject(this);
        }
    }
    
    /**
     * Checks if Mob attacks Player and changes HP by dmg if Player gets hit
     * 
     * @param dmg       The amount to change Player HP by
     */
    public void attack(int dmg) {
        Player p = (Player) getOneIntersectingObject(Player.class);
        if (p == null) {
            return;
        }
        p.changeHP(-dmg);
    }

    public void changeHP(int deltaHP) {
        hp += deltaHP;
    }

    public void changeSpeed(int deltaSpeed) {
        speed += deltaSpeed;
    }

    public int getHP() {
        return hp;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setSpeed(double multiplier) {
        speed = (int) (speed * multiplier);
    }
}
