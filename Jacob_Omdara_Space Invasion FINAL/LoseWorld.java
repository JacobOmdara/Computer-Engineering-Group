import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * is when the user loses, redirected to this screen
 *
 */
public class LoseWorld extends World
{
    // variables for loss screen
    private int width; // width
    private int height; // height
    private int score; // score
    private GreenfootImage loseBackground; // background 
    private WelcomeWorld welcomeLevel; // 
    private GreenfootSound loseMusic; // music
    
    /**
     * Constructor for objects of class LoseWorld, takes in width, height, score
     * 
     */
    public LoseWorld(int width, int height, int score)
    {    
        super(width, height, 1); // the screen
        // background
        loseBackground = new GreenfootImage ("lose screen.png"); 
        setBackground (loseBackground);
        // shows score
        showText(String.valueOf(score), 720, 525);
        // music
        loseMusic = new GreenfootSound ("lose Music.mp3"); 
        loseMusic.playLoop();
    }
    // act
    public void act()
    {
        userInput();
    }
    // takes in user input 
    public void userInput()
    {
        if (Greenfoot.isKeyDown("m") || Greenfoot.isKeyDown("M")) // if the user pressed p or P
        {
            loseMusic.stop();
            welcomeLevel = new WelcomeWorld(); // it would create a new LevelOneWorld
            Greenfoot.setWorld(welcomeLevel); // sets the new world as the default, current running world
        }
        
        if (Greenfoot.isKeyDown("e") || Greenfoot.isKeyDown("E")) // if the user pressed e or E
        {
            System.exit(0); // exits the program
        }
    }
}
