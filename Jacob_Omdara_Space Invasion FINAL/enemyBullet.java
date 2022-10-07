import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * It is the bullet that shoots from an alien and can damage a ship
 * 
 */
public class enemyBullet extends Bullet
{
    // constructor, takes in the bulletSpeed determined by the level
    public enemyBullet (int bulletSpeed)
    {
        // sets the bullet speed from parameter to this bullet speed
        this.bulletSpeed = bulletSpeed;
    }
    
    public void act()
    {
        // runs the hitcheck method
        hitCheck();
        // if the bullet exists
        if (this.getWorld() != null)
        {
            // moves the bullet the speed of bulletSpeed pixels up
            setLocation(getX(), getY() + bulletSpeed);
        }
    }
}
