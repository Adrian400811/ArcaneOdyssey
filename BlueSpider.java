import greenfoot.World;

public class BlueSpider extends Spider {
    private final double speed = 0.5;
    private final int direction = 1;
    private World w;

    public BlueSpider() {
        super();
    }

    public void addedToWorld(World w) {
        this.w = w;
    }

    public void act() {
        super.act();
    }
}
