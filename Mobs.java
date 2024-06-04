import greenfoot.World;

import java.util.List;

public abstract class Mobs extends SuperSmoothMover {
    public World w;
    private int hp;
    private int speed;
    private int range;

    public void addedToWorld(World w) {
        this.w = w;
    }

    public void act() {
        // Boundary
        if (w != null) {
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
        // Collision
        if (getOneObjectAtOffset(getImage().getWidth() / 2, 0, Brick.class) != null) {
            setLocation(getX() - speed, getY());
        }
        if (getOneObjectAtOffset(-(getImage().getWidth() / 2), 0, Brick.class) != null) {
            setLocation(getX() + speed, getY());
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
        List<Player> pNear = getObjectsInRange(range, Player.class);
        if (!pNear.isEmpty()) {
            return pNear.get(0);
        }
        return null;
    }

    public void changeHP(int deltaHP) {
        hp += deltaHP;
    }
}
