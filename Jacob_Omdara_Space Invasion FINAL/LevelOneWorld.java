import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/** This is the first level world, it is the first wave that players will fight in the game. 
 * 
 */
public class LevelOneWorld extends World
{
    // initializing variables, integers and arrays, objects, background 
    private int alienRows; // rows of aliens 
    private int alienColumns; // columns of aliens
    private int alienSpacing; // spacing b/w aliens
    private int width; // width of screen
    private int height; // height of screen
    private int score = 0; // score
    blackAlien Army[][] = new blackAlien[alienRows][alienColumns]; // 2d array
    public static SuperDisplayLabel scoreBar; // the top scorebar for score
    private ship userShip; // the ship
    private Font textFont; // font 
    private GreenfootImage spaceBackground; // background
    private GreenfootSound backgroundSound; // sound
    /**
     * Constructor for objects of class LevelOneWorld.
     * Takes in width and the height from the welcomeworld
     * 
     */
    public LevelOneWorld(int width,int height)
    {    
        // makes a screen with the size of the parameter width, and parameter height
        super(width, height, 1);
        this.width = width;
        this.height = height;
        // makes a new image, assigns it to the background
        spaceBackground = new GreenfootImage ("space background.png");
        setBackground (spaceBackground);
        // makes a new object, in particular a ship named userShip, and adds that ship to the world
        userShip = new ship(3, 30, 1, 4);
        addObject(userShip, 540, 650);
        // makes a new font
        textFont = new Font ("Courier New", 24);
        // makes a new superdisplaylabel with the parameters with width and our font that we made
        scoreBar = new SuperDisplayLabel (width, textFont);
        // add the score bar 
        addObject(scoreBar, width /2, 15);
        // updates the score of the scorebar
        scoreBar.update(new String[] {"Score:"} , new int[] {score});
        // plays the background music
        backgroundSound = new GreenfootSound ("Space Invaders Level Background song.wav"); 
        // runs the setup method
        setup();
    }
    
    public void act()
    {
        // plays music
        musicPlay();
        // if there are no aliens left, or for cheats you press 2 then it will launch the second level 
        if (getObjects(blackAlien.class).size() == 0 || Greenfoot.isKeyDown("2"))
        {   
            // stops music
            musicStop();
            // it makes a new world variable, makes it primary world
            LevelTwoWorld secWorld = new LevelTwoWorld(getWidth(), getHeight(), score);
            Greenfoot.setWorld(secWorld);     
        } 
        // cheat for level 3
        if (Greenfoot.isKeyDown("3"))
        {   
            musicStop();
            // it makes a new world variable, makes it primary world
            LevelThreeWorld thirdWorld = new LevelThreeWorld(getWidth(), getHeight(), score);
            Greenfoot.setWorld(thirdWorld);     
        } 
        // cheat for win world
        if (Greenfoot.isKeyDown("5"))
        {
            musicStop();
            // makes a new winworld variable, and sets it as the main world
            WinWorld wWorld = new WinWorld(width, height, score);
            Greenfoot.setWorld(wWorld); 
        }
        
        // if the ship dies, then launch the lose screen
        if (getObjects(ship.class).size() == 0 || Greenfoot.isKeyDown("6"))
        {
            musicStop();
            // makes a new loseworld variable, and sets it as the main world
            LoseWorld lWorld = new LoseWorld(width, height, score);
            Greenfoot.setWorld(lWorld); 
        }
    }
    
    //setup the level 
    public void setup()
    {
        alienRows = 2; //number of rows of alien
        alienColumns = 8; //number of colums of alien
        alienSpacing = 100; //number of pixel between aliens horizontally
        blackAlien Army[][] = new blackAlien[alienRows][alienColumns];
        //loop through all aliens and add them to the level
        for(int rows = 0; rows < alienRows; rows++)
        {
            for (int columns = 0; columns < alienColumns; columns++)
            {
                // makes a new black alien, assigns it to the army array
                Army[rows][columns] = new blackAlien (90*columns + 100, alienSpacing*rows + 100, 1, alienSpacing, Army, rows, userShip, 1, 2, 200);
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
    // for stopping music
    public void musicStop()
    {
        //stops the music
        backgroundSound.stop();
    }
    // starting music
        public void musicPlay()
    {
        //stops the music
        backgroundSound.play();
    }
}
