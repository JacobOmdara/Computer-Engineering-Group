import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Is a subclass of the bullet class, tracks position of the bullet and movement of bullet from the ship
 */
public class userBullet extends Bullet
{
    // constructor, takes in the bulletSpeed determined by the level
    public userBullet(int bulletSpeed)
    {
        // sets the bullet speed from parameter to this bullet speed
        this.bulletSpeed = bulletSpeed;
    }
    
    // the act method, runs 60 times a second
    public void act()
    {
        // moves the bullet the speed of bulletSpeed pixels up
        setLocation(getX(), getY() - bulletSpeed);
        // runs the hitcheck method
        hitCheck();
    }
}
