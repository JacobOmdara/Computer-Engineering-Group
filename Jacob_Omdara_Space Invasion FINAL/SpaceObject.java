import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The spaceobject covers all of the objects that are meant to be interacted with by the player, including enemies, ships and bullets.
 * 
 */
public class SpaceObject extends Actor
{
    // variables made specifically for inheritance and subclasses 
    public int speed; // speed of the space objects
    public int hp; // health points
    public int cooldown = 0; // cooldown for shooting
    public int cooldownMax;
    public int buffer = 100; // buffer
}
