import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.World;
import greenfoot.*;
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player extends Actor {
    private static int speed;
    private final int dmg;
    private int hp;
    private World w;
    private int jumpActs = 0;
    private int boostActs = 0;
    private GreenfootImage[] R, L, U, D;
    private boolean right, left, down, up, walking, isWaiting; 
    private int directionx, directiony; 
    protected int animIndex, animDelay, animCounter;

    public Player() {
        hp = 5;
        dmg = 1;
        
        R = new GreenfootImage[9];
        L = new GreenfootImage[9];
        U = new GreenfootImage[9];
        D = new GreenfootImage[9];
        for(int i = 0; i < R.length; i++){
                R[i] = new GreenfootImage("GuyR" + i + ".png");
                R[i].scale(70,75);
                L[i] = new GreenfootImage("GuyL" + i + ".png");
                L[i].scale(70,75);
                U[i] = new GreenfootImage("GuyR" + i + ".png"); 
                U[i].scale(70,75);
                D[i] = new GreenfootImage("GuyR" + i + ".png");
                D[i].scale(70,75);
            }
        animDelay = 3;
        setImage(R[0]);
        
    }
    private void initAnim(){
        
        directionx = 1; 
        directiony = 1;
        walking = false; 
        right = true;
        left = false;
        up = false;
        down = false; 
        animIndex = 0;
        animDelay = 6;
        animCounter = animDelay; 
    }

    public void addedToWorld(World w) {
        this.w = w;
    }

    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        jumpActs--;
        boostActs--;
        movement();
        jump();
        fall();
        collision();
        boundary();
        checkHP();
        animate();
        fixDirections(); 
    }

    private void movement() {
        if (Greenfoot.isKeyDown("D")) {
            setLocation(getX() + 8, getY());
            speed = 8;
            directionx = 1;
        }
    
        if (Greenfoot.isKeyDown("A")) {
            setLocation(getX() - 8, getY());
            speed = -8;
            directionx = -1;
        }
        if (Greenfoot.isKeyDown("D")|| Greenfoot.isKeyDown("A")) {
            walking = true;
        }
        else{
            walking = false;
            directionx = -1;
        }

           

    }

    private void fixDirections(){
        if(directionx == 1){
            right = true; 
            left = false; 
        } else{
            left = true; 
            right = false; 
        }
    }

    private void jump() {
        if (Greenfoot.isKeyDown("Space") && getOneObjectAtOffset(0, (getImage().getHeight() / 2) + 1, Brick.class) != null) {
            jumpActs = 30;
        } 
        if (jumpActs > 15) {
            setLocation(getX(), getY() - 8);
        }
        if (boostActs > 15) {
            setLocation(getX(), getY() - 32);
        }
    }

    protected void jumpBoost() {
        boostActs = 30;
    }

    private void fall() {
        if (getOneObjectAtOffset(getImage().getWidth() / 2 - 2, (getImage().getHeight() / 2) + 1, Brick.class) == null && jumpActs < 15) {
            if (getOneObjectAtOffset(-(getImage().getWidth() / 2 - 2), (getImage().getHeight() / 2) + 1, Brick.class) == null && jumpActs < 15) {
                setLocation(getX(), getY() + 8);
            }
        }
    }

    private void boundary() {
        if (w == null) {
            return;
        }
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
            setLocation(getX(), 0);
        }
    }

    private void collision() {
        if (getOneObjectAtOffset(getImage().getWidth() / 2, 0, Brick.class) != null) {
            setLocation(getX() - speed, getY());
        }
        if (getOneObjectAtOffset(-(getImage().getWidth() / 2), 0, Brick.class) != null) {
            setLocation(getX() - speed, getY());
        }
        if (getOneObjectAtOffset(0, -(getImage().getHeight() / 2), Brick.class) != null) {
            setLocation(getX(), getY() + 6);
            jumpActs = 0;
        }
        if (getOneObjectAtOffset(0, (getImage().getHeight() / 2), Brick.class) != null) {
            setLocation(getX(), getY() - 1);
            jumpActs = 0;
        }
    }
    
    private void animate(){
        if(walking){
            if(animCounter == 0){
                animCounter = animDelay;
                animIndex++;
                if(animIndex == R.length){
                    animIndex = 0; 
                }
            } else{
                animCounter--; 
            }
            if(right){
                setImage(R[animIndex]);
            } else if(left){
                setImage (L[animIndex]);
            } else if (up){
                setImage (U[animIndex]); 
            } else if (down){
                setImage (D[animIndex]); 
            }
        } 
    }

    private void checkHP() {
        if (hp <= 0) {
            Greenfoot.setWorld(new GameOverScreen());
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void changeHP(int deltaHP) {
        hp += deltaHP;
    }
    
    public boolean touchingSpike(){
        return (isTouching(Spike.class));
    }
}
