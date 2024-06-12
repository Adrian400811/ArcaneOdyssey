import greenfoot.World;

public class BlueBee extends Bee {
    private final int speed;
    private final int range;
    private final int direction;
    private World w;
    private int[] anchor;

    public BlueBee() {
        super();
        direction = 1;
        speed = 2;
        range = 300;
    }

    public void addedToWorld(World w) {
        super.addedToWorld(w);
        anchor = new int[]{getX(), getY()};
    }

    public void act() {
        
        movement();
        collision();
        super.act();
    }

    private void movement() {
        if (w == null) {
            return;
        }
        if (direction == 1) {
            while (getY() > (anchor[1] - range)) {
                setLocation(anchor[0], getY() + speed);
            }
        } else {
            while (getY() < (anchor[1] + range)) {
                setLocation(anchor[0], getY() - speed);
            }
        }
    }
}
