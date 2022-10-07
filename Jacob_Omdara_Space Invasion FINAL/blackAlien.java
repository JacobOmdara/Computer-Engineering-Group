import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * It is the main alien that appears in the game, it is the main enemy and the objective is to destroy all aliens
 * 
*/
public class blackAlien extends Enemy
{
    // all of the variables and objects
    private int speed;
    private int x;
    private int y;
    private int alienSpacing;
    private int randomNumber;
    private int myRow;
    private int point = 50;
    private int bulletSpeed;
    private int chances;
    // the amount of pixels from the centre of an alien to the sides, depending on negative or not could be left side or right
    private int sideSpacing = 17;
    private blackAlien[][] Army;
    private ship userShip;
    private boolean atbound = false; // to fix the double bounce 

    // constructor for blackAlien, x coordinate, y coordinate, space between alien, 2D array of alien, current row of this alien and the ship
    public blackAlien(int x, int y, int speed, int alienSpacing, blackAlien[][] Army, int myRow, ship userShip, int hp, int bulletSpeed, int chances)
    {
        // sets all of the variables to the values of parameters, etc.
        this.x = x;
        this.y = y; 
        this.speed = speed;
        this.alienSpacing = alienSpacing;
        this.hp = hp;
        this.Army = Army;
        this.myRow = myRow;
        this.userShip = userShip;
        this.bulletSpeed = bulletSpeed;
        this.chances = chances;
    }
    // act method, runs 60 times a second
    public void act()
    {
        // runs the method is at boundary, as well as move method
        isAtBoundary();
        move();
        // runs main method to check if the alien can shoot 
        shootChecker();
    }
    
    public void shootChecker()
    {
        // generates a random number between 0-200
        randomNumber = Greenfoot.getRandomNumber(chances);
        // if the cooldown is greater than 0
        if (cooldown > 0)
        {
            // will subtract the cooldown by 1
            cooldown--;
        }
        // if the cooldown is 0, plus the shoot method is true (no aliens in front) and the randomly generated number is 0
        else if (cooldown == 0 && shoot() == true && randomNumber == 0)
        {
            // will make another random number from 0-100, if its greater or equal to 30
            if (Greenfoot.getRandomNumber(100) >= 30)
            // will add a normal enemy bullet 
            getWorld().addObject(new enemyBullet(bulletSpeed), getX(), getY() + 25);
            else 
            // it will add an aiming bullet
            getWorld().addObject(new AimedBullet(2, userShip), getX(), getY() + 25);
            // cooldown gets set back to 30
            cooldown = cooldownMax;
        }
    }
    // method for shooting
    public boolean shoot()
    {
        // took the dimensions of the alien, checked the middle in front of alien, left back and right back of the alien, as well as one checking 2 aliens in front
        Actor frontAlien1 = getOneObjectAtOffset(0, alienSpacing, blackAlien.class); 
        Actor frontAlien2 = getOneObjectAtOffset(-sideSpacing, alienSpacing, blackAlien.class);
        Actor frontAlien3 = getOneObjectAtOffset(sideSpacing, alienSpacing, blackAlien.class);
        Actor frontAlien4 = getOneObjectAtOffset(0, alienSpacing * 2, blackAlien.class);
        // if there are no actors in front, on the sides or 2 aliens in front then it will return true
        if (frontAlien1 == null && frontAlien2 == null && frontAlien3 == null && frontAlien4 == null)
        {
            return true;
        }
        // else will return false, meaning wont shoot bullet
        return false;
    }
    // pretty cool method, able to move the whole array 
    public void isAtBoundary()
    {
        // if the direction is positive
        if (direction == 1)
        {            
            //going right and exceeded right buffer boundary
            if ((this.atbound == false) && (this.getX() > getWorld().getWidth()- this.buffer))
            {                
                //change direction of all aliens in the row
                for (int columns = 0; columns < Army[myRow].length; columns++)
                {             
                    Army[this.myRow][columns].changeDirection();                  
                }   
                move(this.speed*this.direction*-1); //take one more step into the boundary, this is to ensure that the entire row syncs up
                atbound = true;
            }
        }
        else 
        {
            //going left and exceeded left buffer boundary
            if ((this.atbound == false) && (this.getX() < buffer))
            {     
                //change direction of all aliens in the row
                for (int columns = 0; columns < Army[myRow].length; columns++)
                {             
                    Army[this.myRow][columns].changeDirection();                  
                }   
                move(this.speed*this.direction); //take one more step into the boundary, this is to ensure that the entire row syncs up
                atbound = true;
            }
        }     
        

    }

    // moves by the speed multiplied by the direction
    public void move()
    {
        if (atbound == true)            
            this.atbound = false;  
        else 
            move(this.speed*this.direction);
    }
    // method to change the direction
    public void changeDirection()
    {
        direction = direction * -1;
    }
    // getter method for the points of this specific alien 
    public int getPoint()
    {
        return point;
    }
}
