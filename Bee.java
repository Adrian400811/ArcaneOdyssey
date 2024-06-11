import greenfoot.World;

public abstract class Bee extends Mobs {
    private final int hp;
    private final int speed;
    private final int dmg;
    private Level w;

    public Bee() {
        super();
        hp = 2;
        speed = 1;
        dmg = 1;
    }

    public void addedToWorld(World w) {
        this.w = (Level) w;
    }

    @Override
    public void act() {
        super.act();
        attack();
        collision();
    }
}
