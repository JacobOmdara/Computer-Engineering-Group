import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the bullet that can track the position of the user ship, move in the direction of it from the start.
 */
public class AimedBullet extends Bullet
{
    // variables and a ship object
    private boolean aimed = false;
    private ship userShip;
    // the constructor of the aimedbullet, taking parameters of the user ship as well as the speed 
    public AimedBullet (int bulletSpeed, ship userShip)
    {
        // sets the variables with the values of the parameters
        this.bulletSpeed = bulletSpeed;
        this.userShip = userShip;
    }
    // the act method
    public void act()
    {
        // checks if bullet has hit something
        hitCheck();
        // if its not aimed yet
        if (!aimed)
        {
            // it sets the boolean aimed as true
            aimed = true;
            // turns toward the user ship 
            turnTowards(userShip.getX(), userShip.getY());
        }
        // moves 
        move(bulletSpeed);
    }
    
}
