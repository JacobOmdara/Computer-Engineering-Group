import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * the bullet class covers all bullets, and is used to detect collisions with other space objects.
 */

public class Bullet extends SpaceObject
{
    // variable for all bullets so that it is not initialized in the subclasses
    public int bulletSpeed;
    private GreenfootSound[] explosion;
    private int shootSoundsIndex;
    public Bullet()
    {
        shootSoundsIndex = 0;
        explosion = new GreenfootSound[10];
        
        for (int i = 0; i< explosion.length; i++)
        {
            explosion[i] = new GreenfootSound("explosion sound.wav");
        }
    }
    
    // this method is used for detecting if there is an space object it is in contact with
    public boolean actorContact()
    {
        // finds and names the object that this bullet is in contact with
        SpaceObject contactActor = (SpaceObject) getOneIntersectingObject(SpaceObject.class);
        if (contactActor != null) // if the bullet hits something
        {
             // if alien bullet or tracking bullet hits another alien, then pass through it (prevent friendly fire)
            if ((this instanceof enemyBullet || this instanceof AimedBullet) && contactActor.getClass() == blackAlien.class ) 
                return true;
            
            if (contactActor.hp == 1) // if the object has only 1 hp left
            {                
                getWorld().removeObject(contactActor); //object is dead, remove it
                contactActor.hp--; // set the object's hp to 0 
                explosion[shootSoundsIndex].play(); // plays explosion sound
                shootSoundsIndex++; // code for sounds 
                if (shootSoundsIndex > explosion.length -1)
                {
                    shootSoundsIndex = 0;
                }
                if(contactActor.getClass() == blackAlien.class) //check if contactActor is a blackAlien               
                {
                                          
                    // check if the world is a LevelOneWorld
                        if (getWorld() instanceof LevelOneWorld)
                        {
                        // cast the World into a LevelOneWorld to set the world score 
                        ((LevelOneWorld)getWorld()).setScore(  ((LevelOneWorld)getWorld()).getScore() + ((blackAlien)contactActor).getPoint() * 1/2); // increase worldscore by point of object by 50                                             
                        LevelOneWorld.scoreBar.update(new int[] {((LevelOneWorld)getWorld()).getScore()} ); //update score bar with new score
                        
                    }
                    // check if the world is a LevelTwoWorld
                        if (getWorld() instanceof LevelTwoWorld)
                        {
                        //cast the World into a LevelTwoWorld to set the world score 
                        ((LevelTwoWorld)getWorld()).setScore( ((LevelTwoWorld)getWorld()).getScore() + ((blackAlien)contactActor).getPoint()); // increase worldscore by point of object by 50 
                        LevelTwoWorld.scoreBar.update(new int[] {((LevelTwoWorld)getWorld()).getScore()} ); // update score bar with new score
                        
                    }
                    // check if the world is a LevelThreeWorld
                        if (getWorld() instanceof LevelThreeWorld)
                        {
                        // cast the World into a LevelOneWorld to set the world score 
                        ((LevelThreeWorld)getWorld()).setScore(  ((LevelThreeWorld)getWorld()).getScore() + ((blackAlien)contactActor).getPoint() * 2); // increase worldscore by point of object by 50                                             
                        LevelThreeWorld.scoreBar.update(new int[] {((LevelThreeWorld)getWorld()).getScore()} ); //update score bar with new score
                        
                    }
                  

                }
                // sets the boolean as true, meaning it is in contact with something
                return true;
            }
            // if the actor its in contact with has more than 1 hp
            else if (contactActor.hp > 1)
            {
                // subtract 1 hp
                contactActor.hp--;
            if(contactActor.getClass() == blackAlien.class)  
            {
                // check if the world is a LevelOneWorld
                if (getWorld() instanceof LevelOneWorld)
                {
                // cast the World into a LevelOneWorld to set the world score 
                ((LevelOneWorld)getWorld()).setScore(  ((LevelOneWorld)getWorld()).getScore() + 20); // increase worldscore by point of object by 50                                             
                LevelOneWorld.scoreBar.update(new int[] {((LevelOneWorld)getWorld()).getScore()} ); //update score bar with new score
                
                }
                    // check if the world is a LevelTwoWorld
                if (getWorld() instanceof LevelTwoWorld)
                {
                //cast the World into a LevelTwoWorld to set the world score 
                ((LevelTwoWorld)getWorld()).setScore( ((LevelTwoWorld)getWorld()).getScore() + 30); // increase worldscore by point of object by 50 
                LevelTwoWorld.scoreBar.update(new int[] {((LevelTwoWorld)getWorld()).getScore()} ); // update score bar with new score
                
                }
                    // check if the world is a LevelThreeWorld
                if (getWorld() instanceof LevelThreeWorld)
                {
                // cast the World into a LevelOneWorld to set the world score 
                ((LevelThreeWorld)getWorld()).setScore(  ((LevelThreeWorld)getWorld()).getScore() + 40); // increase worldscore by point of object by 50                                             
                LevelThreeWorld.scoreBar.update(new int[] {((LevelThreeWorld)getWorld()).getScore()} ); //update score bar with new score
            
                }
            }
            
            if(contactActor.getClass() == ship.class)
            {
                                if (getWorld() instanceof LevelOneWorld)
                {
                // cast the World into a LevelOneWorld to set the world score 
                ((LevelOneWorld)getWorld()).setScore(  ((LevelOneWorld)getWorld()).getScore() - 20); // increase worldscore by point of object by 50                                             
                LevelOneWorld.scoreBar.update(new int[] {((LevelOneWorld)getWorld()).getScore()} ); //update score bar with new score
                
                }
                
                // check if the world is a LevelTwoWorld
                if (getWorld() instanceof LevelTwoWorld)
                {
                //cast the World into a LevelTwoWorld to set the world score 
                ((LevelTwoWorld)getWorld()).setScore( ((LevelTwoWorld)getWorld()).getScore() - 40); // increase worldscore by point of object by 50 
                LevelTwoWorld.scoreBar.update(new int[] {((LevelTwoWorld)getWorld()).getScore()} ); // update score bar with new score
                }
                
                // check if the world is a LevelThreeWorld
                if (getWorld() instanceof LevelThreeWorld)
                {
                // cast the World into a LevelOneWorld to set the world score 
                ((LevelThreeWorld)getWorld()).setScore(  ((LevelThreeWorld)getWorld()).getScore() - 60); // increase worldscore by point of object by 50                                             
                LevelThreeWorld.scoreBar.update(new int[] {((LevelThreeWorld)getWorld()).getScore()} ); //update score bar with new score
                }
            }
                // sets the boolean as true, meaning it is in contact with something
            return true;
            }  
            // sets the boolean as false, meaning it is not in contact with something
            return false;
        }
        // sets the boolean as false, meaning it is not in contact with something
        return false;

    }
    
    // a method to check if it either hit another object or is at the edge, remove it
    public void hitCheck()
    {
        // this checks for hit 
        if(actorContact() || this.isAtEdge())
            getWorld().removeObject(this);
    }
}
