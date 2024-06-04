public class RedBee extends Bee {
    private final int range;
    private int hp;
    private int speed;

    public RedBee() {
        super();
        hp = 2;
        speed = 1;
        range = 100;
    }

    public RedBee(int range) {
        this.range = range;
    }

    @Override
    public void act() {
        super.act();
        idle();
        if (getPlayer(range) != null && getDistance(getPlayer(range)) < range) {
            sprint();
        }
    }

    private void idle() {
        int direction = 1;
        if (getObjectsAtOffset(direction * getImage().getWidth() / 2, 0, Brick.class) != null) {
            move(speed);
        } else {
            direction = -1;
        }
    }

    /**
     * Move towards the nearest Player using getPlayer()
     */
    private void sprint() {
        Player p = getPlayer(range);
        int direction;
        if (p.getX() < getX()) {
            direction = getX() - 1;
        } else {
            direction = getX() + 1;
        }
        turnTowards(direction, getY());
        move(speed * 2);
    }
}
