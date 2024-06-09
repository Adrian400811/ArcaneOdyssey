import greenfoot.World;

import java.util.Objects;

public class RedSpider extends Spider {
    private World w;

    public RedSpider() {
        super();
        healPlayer();
    }

    public void addedToWorld(World w) {
        this.w = w;
    }

    private void healPlayer() {
        if (w == null) {
            return;
        }
        Player topL = (Player) getOneObjectAtOffset(-(getImage().getWidth() / 2), getImage().getHeight() / 2, Player.class);
        Player topR = (Player) getOneObjectAtOffset(getImage().getWidth() / 2, getImage().getHeight() / 2, Player.class);
        if (topL != null || topR != null) {
            Objects.requireNonNullElse(topL, topR).changeHP(+1);
        }
    }
}
