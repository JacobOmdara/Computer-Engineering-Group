import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the welcome world, is the first world run, which runs a menu and allows the user to choose between 3 options, playing the game, instructions and leaving the game.
 * 
 *   
 * The Space Invasion by Jacob Omdara!
 * 
 * Features:
 * Fight 3 waves of tough aliens and survive! There is difficulty adjustments for every wave, as the aliens get tougher to fight
 * Get top score on the Leaderboards! Be on top with surviving and killing as many aliens as possible!
 * There are different projectiles that can harm you and kill you!
 * 
 * Scoring:
 * Hitting an alien with more than 1 hp nets you 20(30 and 40 depending on wave) points, while killing one nets you 25 (50 or 100 depending on wave) points. you also lose points if you are hit
 * (-20, -40 and -60 by wave)
 * 
 * How to play:
 * Start the game from the welcomeWorld by pressing p. You will face off against waves of enemies.
 * Dodge the bullets by using the left and right arrow keys or a and d. you can also kill the aliens by pressing space.
 * Win by either defeating all 3 waves, or lose by running out of health points. (3 per wave)
 * Aim for the Highest score and see if you can beat my personal 3540!
 * 
 * Other:
 * Didnt have enough time for other big things I wanted to implement, but this game is something I am proud of. 
 * I recommend you check out the 2d array and collision checking in the blackAlien class. All the core mechanics are functional, and most of the game is without bugs.
 * I would say the most important things to check out are probably the alien formation, as well as the collision, point system as well as just to have fun because its really a game and thats about it
 * Also sorry about the name blackAlien, It was originally a black one, but changed it cuz the background was black
 * 
 * ***********ALSO IF YOU WANT TO SKIP******************
 * press 2 on the first level, to skip to level 2. 3 for the third, and 5 for win screen, and 6 for lose screen. This only works in the first level for cheats.
 * 
 * Known bugs:
 * There is a bit of a bug with the music playing twice if it's either your first time booting up the program, but Im not sure if its greenfoot, my computer or the code.
 * If you find any others please send them to me when marking as I would like to see how I could solve them! Thanks 
 * 
 * Sources:
 * Used inspiration from SLYNYRD for the tracking bullet, on pinterest https://www.pinterest.ca/pin/28147566414703917/
 * Used 1ZOOM.ME for the win screen background https://www.1zoom.me/en/wallpaper/230155/z512.3/
 * Used FreePNGimg.com space invaders for inspiration for my aliens https://freepngimg.com/png/32283-space-invaders-hd
 * Used vectorStock for inspiration on my ship https://www.vectorstock.com/royalty-free-vector/cute-space-invaders-in-pixel-art-style-on-deep-vector-34495992
 * Used Yellow Magic Orchestras Music, Firecracker(1979) for my menu music https://www.youtube.com/watch?v=OkkFST5qrLg
 * Used Space Invaders - Space Invaders(2016) by SilvaGunner for level music, https://www.youtube.com/watch?v=k9oyDTR0EwQ
 * Used Results(4 Stars) - Wii Fit Soundtrack from Nintendo, for win music https://www.youtube.com/watch?v=ryOkOk-Ntj8
 * Used Results(1 Star) - Wii Fit Soundtrack from Nintendo for lose music https://www.youtube.com/watch?v=qSFFQZEhZCs
 * Used adobe stock photos, for the earth exploding background (lose screen first image in link) https://stock.adobe.com/search?k=earth+exploding
 * The game background got taken down, as well as the one for the menu, here are the links https://wallpaperaccess.com/pixel-space
 * Used Greenfoot to help on how to check if the enemy is dead, progress to next level https://www.greenfoot.org/topics/61143/0
 * Used PixilArt and Photo for many assets and for editing https://www.pixilart.com/draw# https://www.photopea.com/
 * Used Dropbox to transfer and backup photos and files
 * 
 * Used Mr. Cohen's library for the Stat bar, as well as the Super Display label which were really helpful (in classroom)
 * Used implementation of music slides as well, how to use arrays for playing clips over each other
 * 
 * ENJOY THE GAME! :D
 * 
 * VERSIONS:
 *
 *  version 0.8
 * the working beta beta version of project, implemented movement of aliens, as well as bullet checking 
 * known bugs are the last alien being out of sync, as well as the wallpaper with transparency, will change that asap
 * 
 * version 0.8.1
 * fixed the title screen, still working on lives and bar display
 * same bugs as version 0.8
 * 
 * version 0.8.2 
 * added display label with Cohen help, copied from library, and need to find how to implement other variables from actor to world
 * 
 * version 1
 * submitted the beta, added a line comment at the start, did comments
 * 
 * version 1.1
 * added the scoreboard, added the leveltwoworld and also implemented the loseworld and winworld, a lot of work
 * same bugs as version 0.8, errors in bullet class, need to fix
 * 
 * version 1.1.1
 * changed speed of alien and ship in second level, working on reorganizing the code
 * known bugs is the right alien moving 2 times every border check, aliens shooting other aliens below
 * 
 * version 1.1.2
 * commented levelone and the welcome world
 * 
 * version 1.2.0
 * changed the colour of the ships, added a new tracking bullet and also fixed most of the code
 * new bugs with orientation of bullet, will change design later
 * 
 * 
 * version 1.2.1
 * fixed art and edited image for the tracking bullet, as well as enemy bullet and user bullet
 * no new bugs 
 * 
 * version 1.2.2
 * added comments on multiple classes, fixing tracking of bullet prevention, shooting own alien
 * 
 * version 1.3
 * changed level 1 and level 2 difficulties, as well as added multiple barrels for bullets to shoot
 * was also able to comment all code, and worked on improving class and reduce hard coding 
 * aliens still shooting other aliens is annoying, also the aimed bullet might miss the ship sometimes
 * 
 * version 1.4
 * implemented a health bar, worked hard to solve alien problem (solved), also have an issue with the health
 * bar not popping up until hit, as well as double bounce
 * will work hard tmr to finish up sounds and art
 * 
 * version 1.5
 * added win and lose screens, fixed speed as well as fixed lose and win screens, fixed health bar issue
 * planning to add introduction screen, as well as third level
 * 
 * version 1.6
 * added all sounds, animations and almost done everything, working on commenting and what not
 * 
 * version FINAL
 * Done everything, fixed the double bounce bug :D
 * 
 */
// this is the welcome world, starting world 
public class WelcomeWorld extends World
{
    // defining the image and world variables
    private GreenfootImage titleScreen;
    private LevelOneWorld LevelOne;
    private InstructionWorld InstWorld;
    private GreenfootSound menuMusic;
    // constructor 
    public WelcomeWorld()
    {    
        // makes a new screen size with dimensions of 1080x720 pixels
        super(1080, 720, 1); 
        // sets titleScreen as a new image
        GreenfootImage titleScreen = new GreenfootImage ("space invasion title screen.png");
        // sets titleScreen as the background
        setBackground (titleScreen);
        // makes and plays music
        menuMusic = new GreenfootSound ("Menu music.wav"); 
        Greenfoot.setSpeed(50);
        menuMusic.play();
    }
    // loops the code in the method 60 times a second
    public void act()
    {
        // runs userInput() 60 times a second
        userInput();
    }
    // method to check what the user inputted
    public void userInput()
    {
        if (Greenfoot.isKeyDown("p") || Greenfoot.isKeyDown("P")) // if the user pressed p or P
        {
            // stops music
            menuMusic.stop();
            LevelOne = new LevelOneWorld(getWidth(), getHeight()); // it would create a new LevelOneWorld
            Greenfoot.setWorld(LevelOne); // sets the new world as the default, current running world
        }
        
        if (Greenfoot.isKeyDown("i") || Greenfoot.isKeyDown("I")) // if the user pressed i or I
        {
            menuMusic.stop();
            InstWorld = new InstructionWorld(getWidth(), getHeight()); // it would create a new WelcomeWorld
            Greenfoot.setWorld(InstWorld); // sets the new world as the default, current running world
        }
        
        if (Greenfoot.isKeyDown("e") || Greenfoot.isKeyDown("E")) // if the user pressed e or E
        {
            System.exit(0); // exits the program
        }
    }
    
}
