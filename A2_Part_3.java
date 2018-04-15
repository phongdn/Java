// Assignment 2.0, by Phong Nguyen
// Winter quarter, 2015, for BIT 115 (Instructor: Megan Hazen)
import becker.robots.*;
import java.util.Random;

class RobotDetect extends Robot
{
   int backpack = 0;   //Created a counter to record the amount of things in robot robs backpack.
   RobotDetect(City c, int st, int ave, Direction dir, int num)
   {
      super(c, st, ave, dir, num);
   }
   public void Smartmove()
   {
      while (this.frontIsClear())   //Command to detect if there is a wall in front of robot rob so he does not crash.
      {
      this.move();
         if (this.canPickThing())  //This loop will constantly check if robot rob is on a thing. If he is he will pick it up.
         {
         this.pickThing();
         backpack++;       //The backpack counter is then added one for every thing Robot rob picks up.
         }
      }
   }
   public void ResetPosition()  //Creating a command to return robot rob to next section of hallways.
   {
      this.TurnAround();  //Command to turn 180 degrees
      this.Smartmove();  //Added the previous detection command in this one
      this.turnLeft();
      this.move();
      this.turnLeft();
   }
   public void TurnAround() //Turns 180 degrees
   {
      this.turnLeft();
      this.turnLeft();
   }
   public void PlaceObjects()
   {
      while (backpack != 0)  //while backpack is not equal to zero, robot rob will continue to move and place objects
      {
         this.move();
         this.putThing();
         backpack--;  //Subtracts 1 from counter backpack every time a object is placed
      }
   } 
   public void GoHome() //command to return robot rob to home position
   {
      this.TurnAround();
      this.SkipFour(); //commad to move four spaces
      this.turnRight(); 
      this.SkipFour();
      this.turnRight();
   }
   public void turnRight() //included the turn right command
   {
      this.turnLeft();
      this.turnLeft();
      this.turnLeft();
   }
   public void SkipFour() //moves four spaces
   {
      this.move();
      this.move();
      this.move();
      this.move();
   }
   public void doEverything() //Everything put into one command
      {
        this.Smartmove();
        this.ResetPosition();
        this.Smartmove();
        this.ResetPosition();
        this.Smartmove();
        this.ResetPosition();
        this.Smartmove();
        this.ResetPosition();
        this.PlaceObjects();
        this.GoHome();
      }              
}    



public class A2_Part_3 extends Object
{
    public static void main(String[] args)
    {   
        City wallville = new City(6, 12);
        RobotDetect rob = new RobotDetect(wallville, 1, 2, Direction.EAST, 0);
        
        A2_Part_3.BuildCity(wallville); // this jumps down to the "BuildCity" routine, below

        // * * * Your code to race around the race track goes here:  * * *
        
        rob.doEverything();
       
    }
    
    public static void BuildCity(City wallville)
    {
        // Width and height must be at least 2 (each)
        // Feel free to change these numbers, and see how your racetrack changes
		

		Random r = new Random();
		int top = 1;
		int left = 2;
		int height = 4;
		int width = 7 + r.nextInt(4);
		
        int streetNumber = top;
        while(streetNumber <= height)
        {
			if(streetNumber == 1)
            {
				// the topmost line:
				new Wall(wallville, streetNumber, left, Direction.NORTH);
			}
			else if ( streetNumber == height )
            {
				// generate the 'holding spot' thing at the bottom:
				
				// the corner:
				new Wall(wallville, streetNumber+1, left, Direction.WEST);
				new Wall(wallville, streetNumber+1, left, Direction.SOUTH);
				int spotNum = left + 1;
				int counter = 0;
				while(counter < height)
				{
					new Wall(wallville, streetNumber+1, spotNum, Direction.NORTH);
					new Wall(wallville, streetNumber+1, spotNum, Direction.SOUTH);
					// Uncomment the next line for a 'final state' picture (i.e., the second picture
					// in the assignment)
					// new Thing(wallville, streetNumber+1, spotNum);
					spotNum = spotNum + 1;
					counter = counter + 1;
				}
				new Wall(wallville, streetNumber+1, spotNum, Direction.WEST);
			}
			
			// the west-most, vertical line:
			new Wall(wallville, streetNumber, left, Direction.WEST);
			// the east-most, vertical line:
			new Wall(wallville, streetNumber, width, Direction.EAST);
			// the Thing at the end of the tunnel
			new Thing(wallville, streetNumber, width);

			int aveNum = left+1;
			while(aveNum <= width)
			{
				new Wall(wallville, streetNumber, aveNum, Direction.NORTH);
				new Wall(wallville, streetNumber, aveNum, Direction.SOUTH);
				aveNum = aveNum + 1;
			}
            
            streetNumber = streetNumber + 1;
        }		
    }        
}
