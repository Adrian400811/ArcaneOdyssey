import greenfoot.World;

public class Spider extends Mobs {
    private final int hp;
    private final double speed;
    private final int dmg;
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
    }

    public void addedToWorld(World w) {
        this.w = w;
    }

    public void act() {
        if (checkBlock()) {
            holdAct--;
            hold();
        } else {
            movement();
        }
        attack();
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
            if (elapsedTime > 10 * 1000 && getWorld() != null) {
                w.removeObject(this);
            }
        }
    }
}
