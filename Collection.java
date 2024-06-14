import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Collection Class
 * 
 * @author Daniel, Adrian, Jimmy
 * @version June 13 2024
 */
public class Collection extends SuperSmoothMover
{
    protected GreenfootSound collected = new GreenfootSound("kaching.mp3");
    protected static GreenfootSound[] collectedSound;
    protected static int collectedSoundIndex;
    /**
     * Act - do whatever the Collection wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    /** Plays collected sound */
    protected void playCollected() {
        collectedSound[collectedSoundIndex].setVolume(50);
        collectedSound[collectedSoundIndex].play();
        collectedSoundIndex++;
        if (collectedSoundIndex >= collectedSound.length) {
          collectedSoundIndex = 0;
        }
    }

      /** Pre-loads sounds for collected up From Mr.Cohen's Demo Tutorial */
    protected static void init() {
        collectedSoundIndex = 0;
        collectedSound = new GreenfootSound[48];
        for (int i = 0; i < collectedSound.length; i++) {
          collectedSound[i] = new GreenfootSound("kaching.mp3");
          collectedSound[i].play();
          Greenfoot.delay(1);
          collectedSound[i].stop();
        }
    } 
}
