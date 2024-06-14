/**
 * RedBee Class
 *
 * @author Adrian, Jason
 * @version June 13 2024
 */

public class RedBee extends Bee {
    private final int range;
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

        curSpeed = speed;
        if (getPlayer(range) != null) {
            sprint();
        } else {
            idle();
        }
        super.act();
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
