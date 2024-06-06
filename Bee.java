public abstract class Bee extends Mobs {
    private final int hp;
    private final int speed;

    public Bee() {
        super();
        hp = 2;
        speed = 1;
    }

    public void act() {
        boundary();
    }

    private void boundary() {
        if (w != null && (getX() < 0 || getX() > w.getWidth() || getY() < 0 || getY() > w.getHeight())) {
            w.removeObject(this);
        }
    }
}
