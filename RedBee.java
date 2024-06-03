import greenfoot.*;
import java.util.ArrayList;
public class RedBee extends Bee {
    private final int speed = 2;
    private int area;

    public RedBee() {

    }

    public RedBee(int area) {
        this.area = area;
    }

    /**
     * Get distance to a given Pedestrian 1
     * Inspired by Gevater_Tod4177 on greenfoot.org
     * <a href="https://www.greenfoot.org/topics/4911">...</a>
     *
     * @param p Pedestrian 1
     */
    public double getDistance(Player p) {
        return Math.hypot(p.getX() - getX(), p.getY() - getY());
    }

    /**
     * Get the nearest Pedestrian 1 by comparing distances between
     * all the Pedestrian 1s in range
     * Inspired by Gevater_Tod4177 on greenfoot.org
     * <a href="https://www.greenfoot.org/topics/4911">...</a>
     */
    public Player getPlayer() {
        ArrayList<Player> pNear = (ArrayList<Player>) getObjectsInRange(1280,Player.class);
        Player nearestP = null;
        if (!pNear.isEmpty()){
            nearestP = pNear.get(0);
        }
        return nearestP;
    }

    /**
     * Move towards the nearest Player using getNearestPed()
     */
    public void followNearestP() {
        Player p = getPlayer();
        if(p != null){
            turnTowards(p);
            move(speed);
        }
    }

}
