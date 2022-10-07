import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * when the user wins, redirected to this screen
 */
public class WinWorld extends World
{
    // variables
    private int width; // explained all in lose world 
    private int height; 
    private GreenfootImage winBackground;
    private WelcomeWorld welcomeLevel;
    private GreenfootSound winMusic; 
    /**
     * Constructor for objects of class WinWorld, takes in same parameters as lose world
     * 
     */
    public WinWorld(int width, int height, int score)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(width, height, 1); 
        // sets background
        winBackground = new GreenfootImage ("win screen.png");
        setBackground (winBackground);
        // plays, sets music
        winMusic = new GreenfootSound("win Music.mp3");
        winMusic.play();
        showText(String.valueOf(score), 580, 560);
    } 
    
    public void act()
    {
        userInput();
    }
    
    public void userInput()
    {
        if (Greenfoot.isKeyDown("m") || Greenfoot.isKeyDown("M")) // if the user pressed p or P
        { 
            // stops music
            winMusic.stop();
            welcomeLevel = new WelcomeWorld(); // it would create a new LevelOneWorld
            Greenfoot.setWorld(welcomeLevel); // sets the new world as the default, current running world
        }
        
        if (Greenfoot.isKeyDown("e") || Greenfoot.isKeyDown("E")) // if the user pressed e or E
        {
            System.exit(0); // exits the program
        }
    }
}
