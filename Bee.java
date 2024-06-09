import greenfoot.World;

public abstract class Bee extends Mobs {
    private final int hp;
    private final int speed;
    private final int dmg;
    private World w;

    public Bee() {
        super();
        hp = 2;
        speed = 1;
        dmg = 1;
    }

    public void addedToWorld(World w) {
        this.w = w;
    }

    @Override
    public void act() {
        collision();
        boundary();
    }

    private void boundary() {
        if (w == null) {
        }
//        ImgScroll bounds = (ImgScroll) getOneIntersectingObject(ImgScroll.class);
//        if (bounds == null) {
//            w.removeObject(this);
//        }
    }
}
