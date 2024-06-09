public class RedBee extends Bee {
    private final int range;
    private int hp;
    private int baseSpeed;
    private int speed;
    private int direction;

    public RedBee() {
        super();
        hp = 2;
        baseSpeed = 1;
        range = 100;
        direction = 1;
    }

    public RedBee(int range) {
        this.range = range;
    }

    @Override
    public void act() {
        super.act();
        speed = baseSpeed;
        if (getPlayer(range) != null && getDistance(getPlayer(range)) < range) {
            sprint();
        } else {
            idle();
        }
    }

    private void idle() {
        if (getWorld() == null) {
            return;
        }
        turnTowards(direction * 999, getY());
        if (getOneObjectAtOffset(direction * getImage().getWidth(), 0, Brick.class) != null) {
            direction *= -1;
        } else {
            move(speed);
        }
    }

    /**
     * Move towards the nearest Player using getPlayer()
     */
    private void sprint() {
        Player p = getPlayer(range);
        turnTowards(p);
        speed = baseSpeed * 2;
        move(speed);
    }
}
