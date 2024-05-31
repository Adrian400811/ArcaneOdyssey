import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private ImgScroll scroll;
    private Player player;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1, false); 
        addObject(player = new Player(), 100, 622);
        scroll = new ImgScroll(this, new GreenfootImage("2dPixelForestBackground.png"), 2560, 720);
        for (int j=0; j<scroll.getScrollHeight()-100; j+=300){
            for (int i=0; i<scroll.getScrollWidth(); i+=106){
                addObject(new Block(), 0+i, 700);
            }
        }
    }
    
    
    public void act(){
        scroll.scroll(getWidth()/2-player.getX(), getHeight()/2-player.getY());
    }
    
    public void spawnTerrain(int[][] identifier){
        for (int i = 0; i < identifier.length; i++){
            for (int j = 0; j < identifier[i].length; j++){
                
            }
        }
    }
}
