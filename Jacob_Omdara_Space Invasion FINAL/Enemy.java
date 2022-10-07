import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * for the blackalien class, for variables 
 * 
 */
public class Enemy extends SpaceObject
{
    int direction;
    // constructor, enemy and direction, cooldown
    public Enemy()
    {
        direction = 1; // direction of the enemy first
        cooldownMax = 30;
    }
    
}
