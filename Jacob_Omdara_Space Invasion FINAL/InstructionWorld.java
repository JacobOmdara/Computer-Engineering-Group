import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * for Instructions, teach players how to play the game
 * 
 */
public class InstructionWorld extends World
{
    // the variables
    private GreenfootImage introBackground; // background
    private WelcomeWorld welcomeLevel; // the welcome level
    private GreenfootSound instMusic; // instruction music
    /**
     * Constructor for objects of class InstructionWorld, has width and height
     * 
     */
    public InstructionWorld(int width, int height)
    {    
        super(width, height, 1); // screen
        // sets background
        introBackground = new GreenfootImage("intro screen.png");
        setBackground (introBackground);
        // sets and plays music
        instMusic = new GreenfootSound ("Menu music.wav"); 
        instMusic.play();
    }
    // act method 
    public void act()
    {
        userInput();
    }
    // to check if user is doing anything
    public void userInput()
    {
        if (Greenfoot.isKeyDown("m") || Greenfoot.isKeyDown("M")) // if the user pressed p or P
        {
            // stops music
            instMusic.stop();
            welcomeLevel = new WelcomeWorld(); // it would create a new welcomeWorld
            Greenfoot.setWorld(welcomeLevel); // sets the new world as the default, current running world
        }
    }
}
