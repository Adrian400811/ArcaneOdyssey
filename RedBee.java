public class RedBee extends Bee {
    private final int range;
    private final int direction = 1;
    private int hp;
    private int curSpeed;
    private int speed;

    public RedBee() {
        super();
        hp = 2;
        speed = 2;
        range = 100;
    }

    public RedBee(int range) {
        this.range = range;
    }

    @Override
    public void act() {
        super.act();
        curSpeed = speed;
        if (getPlayer(range) != null) {
            sprint();
        } else {
            idle();
        }
        
    }


    /**
     * Move towards the nearest Player using getPlayer()
     */
    private void sprint() {
        Player p = getPlayer(range);
        turnTowards(p);
        curSpeed = speed * 2;
        move(curSpeed);
    }
}
