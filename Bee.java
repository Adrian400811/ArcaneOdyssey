import greenfoot.World;

/**
 * Bee Class
 * 
 * @author Adrian, Jason
 * @version June 13 2024
 */
public abstract class Bee extends Mobs {
    private final int hp;
    private final int speed;
    private final int dmg;
    private Level w;

    public Bee() {
        super();
        hp = 2;
        speed = 2;
        dmg = 1;
    }

    public void addedToWorld(World w) {
        this.w = (Level) w;
    }

    @Override
    public void act() {
        attackAct++;
        attack(dmg);
        collision();
        super.act();
    }
}
