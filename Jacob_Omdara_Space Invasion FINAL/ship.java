import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The ship that the user uses to combat the aliens.
 * 
 * 
 */
public class ship extends SpaceObject
{
    // variables, used for not spamming bullets and to indicate level
    private int maxCooldown;
    private int level;
    private int bulletSpeed;
    private StatBar hpBar;
    private GreenfootSound[] shipShoot; // for sounds 
    private int shootSoundsIndex;
    
    public ship(int speed, int maxCooldown, int level, int bulletSpeed)
    {
        this.speed = speed;   
        this.maxCooldown = maxCooldown;
        this.level = level;
        this.bulletSpeed = bulletSpeed;
        // scales the image of the ship down to 60x60 pixels
        getImage().scale(64,64);
        // hp is 3
        hp = 3;
        hpBar = new StatBar (hp, hp, this, 65, 10 , -50); // this = me, my
        shootSoundsIndex = 0;
        shipShoot = new GreenfootSound[10];
        
        for (int i = 0; i< shipShoot.length; i++)
        {
            shipShoot[i] = new GreenfootSound("ship shoot sound.wav");
        }
    }
    // for the health bar
    public void addedToWorld (World w)
    {          
        w.addObject (hpBar, getX(), getY()); // adds the health bar
        hpBar.update(hp); // updates it
    }
    
    
    // main act method, runs 60 times a second 
    public void act()
    {
        // runs method moveship (used to move left or right)
        moveShip();
        // runs the shooting method
        bulletShootShip();
        hpBar.update(hp); // updates health bar
    }
    
    // main moving method 
     public void moveShip()
    {
        // to check if there is boundaries in the left section, as well if user is pressing left key, also able to move left 
        if(getX() > buffer && (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")))
        // move in the left direction
        move(-speed);
        // if there is boundaries in the right section, and the user is pressing right key, able to move right
        if(getX() < getWorld().getWidth() - buffer && ( Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")))
        move(speed);
    }
    
    public void bulletShootShip()
    {
        // if the cooldown is greater than 0, will reduce by 1
        if (cooldown > 0)
        cooldown--;
        // if the space bar is pressed and cooldown is 0 
        if(Greenfoot.isKeyDown("space") && cooldown == 0)
        {
            // creates a bullet 
            if (level == 1 || level == 2)
            getWorld().addObject(new userBullet(bulletSpeed), getX() , getY() - 40); // shoots 1 bullet
            if (level == 3) // if it is level 3
            {
                getWorld().addObject(new userBullet(bulletSpeed), getX() -25 , getY() - 35);
                getWorld().addObject(new userBullet(bulletSpeed), getX() +25 , getY() - 35); // shoots 2 bullets 
            }
            shipShoot[shootSoundsIndex].play(); // plays the shooting sound
            shootSoundsIndex++;
            if (shootSoundsIndex > shipShoot.length -1) // method
            {
                shootSoundsIndex = 0;
            }
            cooldown = maxCooldown;
            
        }
    }
    // returns his hp
    public int hp (int hp)
    {
        return hp;
    }
    // checks if ship dead
    public boolean checkDeath(int hp)
    {
        if (hp == 0)
        return true;
        return false;
    }
    
}
