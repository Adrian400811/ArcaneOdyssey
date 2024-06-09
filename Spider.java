import greenfoot.World;

public class Spider extends Mobs {
    private final int hp;
    private final double speed;
    private final int dmg;
    private World w;
    private long startTime;
    private boolean oob = false;

    public Spider() {
        hp = 2;
        speed = 0.5;
        dmg = 1;
    }

    public void addedToWorld(World w) {
        this.w = w;
    }

    public void act() {
        timeout();
    }

    public void timeout() {
        if (w == null) {
            return;
        }
        if (!oob && (getX() < 0 || getX() > w.getWidth() || getY() < 0 || getY() > w.getHeight())) {
            oob = true;
            startTime = System.currentTimeMillis();
        }
        if (oob && !(getX() < 0 || getX() > w.getWidth() || getY() < 0 || getY() > w.getHeight())) {
            oob = false;
        }
        if (oob) {
            long elapsedTime = System.currentTimeMillis() - startTime;
            if (elapsedTime > 10 * 1000) {
                w.removeObject(this);
            }
        }
    }
}
