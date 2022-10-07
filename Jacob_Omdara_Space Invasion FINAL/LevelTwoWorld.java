import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the second world, it is the second wave that players will fight in the game. 
 * 
 */
public class LevelTwoWorld extends World
{
    // initializing variables, integers and arrays, objects, background 
    private int alienRows; // all explanations on level one world for variables 
    private int alienColumns;
    private int alienSpacing;
    private int score;
    private int width;
    private int height;
    blackAlien Army[][] = new blackAlien[alienRows][alienColumns];
    public static SuperDisplayLabel scoreBar;
    public static ship userShip;
    private Font textFont;
    private GreenfootImage spaceBackground;
    private GreenfootSound backgroundSound;
    /**
     * Constructor for objects of class LevelOneWorld.
     * Takes in width and the height and score from the welcomeworld
     */
    public LevelTwoWorld(int width,int height, int score)
    {    
        // makes a screen with the size of the parameter width, and parameter height
        super(width, height, 1); 
        this.width = width;
        this.height = height;
        // makes a new image, assigns it to the background
        spaceBackground = new GreenfootImage ("space background.png");
        setBackground (spaceBackground);
        // makes a new object, in particular a ship named userShip, and adds that ship to the world
        userShip = new ship(4, 25, 2, 5); // adds ship 
        addObject(userShip, 540, 650);
        // sets score from last level
        this.score = score;
        // makes a new font
        textFont = new Font ("Courier New", 24);
        // makes a new superdisplaylabel with the parameters with width and our font that we made
        scoreBar = new SuperDisplayLabel (width, textFont);
        // add the score bar 
        addObject(scoreBar, width /2, 15);
        // plays the background music
        backgroundSound = new GreenfootSound ("Space Invaders Level Background song.wav"); 
        backgroundSound.playLoop();
        // updates the score of the scorebar
        scoreBar.update(new String[] {"Score:"} , new int[] {score});
        // runs the setup method
        setup2();
    }
    
    public void act()
    {
        // if there are no aliens left, then it will launch the third level
        if (getObjects(blackAlien.class).size() == 0)
        {
            //stops music
            musicStop();
            // it makes a new 3rd level world variable, makes it primary world
            LevelThreeWorld threeWorld = new LevelThreeWorld(width, height, score);
            Greenfoot.setWorld(threeWorld);     
        } 
        
        //  if the ship dies, then launch the lose screen
        if (getObjects(ship.class).size() == 0)
        {
            //stops music
            musicStop();
            // makes a new loseworld variable, and sets it as the main world 
            LoseWorld lWorld = new LoseWorld(width, height, score);
            Greenfoot.setWorld(lWorld); 
        }
    }
        
    //setup the level 
    public void setup2()
    {
        alienRows = 3; //number of rows of alien
        alienColumns = 8; //number of colums of alien
        alienSpacing = 75; //number of pixel between aliens horizontally
        blackAlien Army[][] = new blackAlien[alienRows][alienColumns];
        
        //loop through all aliens and add them to the level
        for(int rows = 0; rows < alienRows; rows++)
        {
            for (int columns = 0; columns < alienColumns; columns++)
            {
                // makes a new black alien, assigns it to the army array
                Army[rows][columns] = new blackAlien (90*columns + 100, alienSpacing*rows + 100, 1 + rows, alienSpacing, Army, rows, userShip, 2, 3, 150);
                // adds the object into the world
                addObject(Army[rows][columns], 90*columns + 100, alienSpacing*rows + 100);
            }
        }
    }
    
    // getter method, for score
    public int getScore()
    {
        return score;
    }
    // setter method, for score
    public void setScore(int newScore)
    {
        score = newScore;
    }
    
    public void musicStop()
    {
        //stops the music
        backgroundSound.stop();
    }
    
}
