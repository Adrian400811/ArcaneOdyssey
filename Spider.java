import greenfoot.GreenfootImage;
import greenfoot.World;

/**
 * Spider Class
 * 
 * @author Adrian, Jason(graphics)
 * @version June 13 2024
 */
public class Spider extends Mobs {
    private final int hp;
    private final double speed;
    private final int dmg;
    private final GreenfootImage image;
    private World w;
    private int direction = 1;
    private long startTime;
    private boolean oob = false;
    private int holdAct = 0;
    private boolean holding = false;

    public Spider() {
        hp = 2;
        speed = 1;
        dmg = 1;
        image = new GreenfootImage("spider.png");
        image.scale(47, 64);
        setImage(image);
    }

    public void addedToWorld(World w) {
        this.w = w;
    }

    public void act() {
        if (checkBlock() || checkY()) {
            holdAct--;
            hold();
        } else {
            movement();
        }
        attack(dmg);
        timeout();
        super.act();
    }

    protected void movement() {
        if (getWorld() == null || holding) {
            return;
        }
        setLocation(getX(), getY() + (speed * direction));
    }

    protected void hold() {
        if (!holding) {
            holding = true;
            holdAct = 60;
        }
        if (holdAct == 0) {
            holding = false;
            direction *= -1;
            setLocation(getX(), getY() + (5 * direction));
        }
    }

    private boolean checkBlock() {
        return getOneIntersectingObject(Tile.class) != null;
    }

    private boolean checkY() {
        return (getY() < 0 || getY() > w.getHeight());
    }

    public void timeout() {
        if (w == null) {
            return;
        }
        if (!oob && (getX() < 0)) {
            oob = true;
            startTime = System.currentTimeMillis();
        }
        if (oob && !(getX() < 0)) {
            oob = false;
        }
        if (oob) {
            long elapsedTime = System.currentTimeMillis() - startTime;
            if (elapsedTime > 10 * 1000 && getWorld() != null) {
                w.removeObject(this);
            }
        }
    }
}
