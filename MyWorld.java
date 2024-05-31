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
    private int[][] blockGeneration;

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
                addObject(new Brick(), 0+i, 700);
            }
        }
        blockGeneration = new int[40][20];
        blockGeneration[10][5] = 1;
        blockGeneration[11][5] = 1;
        blockGeneration[12][5] = 1;
        blockGeneration[28][5] = 1;
        spawnTerrain(blockGeneration);
    }
    
    
    public void act(){
        scroll.scroll(getWidth()/2-player.getX(), getHeight()/2-player.getY());
    }
    
    /**
     * NOTE - Use a 2d array of [40][10] for this to work as intended
     * Each value in the array represents 64x and 72y
     */
    public void spawnTerrain(int[][] identifier){
        for (int i = 0; i < identifier.length; i++){
            for (int j = 0; j < identifier[i].length; j++){
                if (identifier[i][j] == 1){
                    // i represents the X-values and j represents the y-values
                    addObject(new Brick(), i*64, j*72);
                }
            }
        }
    }
}
