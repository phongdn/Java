// Assignment 4.0, by Phong Nguyen
// Winter quarter, 2015, for BIT 115 (Instructor: Megan Hazen)
import becker.robots.*;

class HistogramRobot extends Robot
{
	// CONSTRUCTOR
   HistogramRobot(City c, int st, int ave, Direction dir, int num)
   {
      super(c, st, ave, dir, num);
   }
    
	 
   public void drawRow( int width ) //Commad to putThing based on the value of array
   {
      for(int D = 0; D<width; D++)
      {
         this.putThing();
         this.move();
      }
   }
	 
   public void turnRight()  //turnAround + turn Left = 270 degrees
   {
      this.turnAround();
      this.turnLeft();
   }
	 
   public void turnAround() //turns 180 degrees
   {
      this.turnLeft();
      this.turnLeft();
   }
    
   public void MoveToNextRow() //returns robot to the starting Avenue and down to the next Street facing East
   {
      this.turnAround();
      while (this.getAvenue() != 1) //when Avenue not equal to 1
      {
         this.move();
      }
      this.turnLeft();
      this.move();
      this.turnLeft();
   }
   public void drawHistogram(int[] histToDraw)  //main command to draw entire histogram //used array parameter
   {
      for(int repeat=0; repeat < histToDraw.length; repeat++)  //repeats the amount of times of the legnth of the array
      {
         this.drawRow(histToDraw[repeat]);  //draws each row based on array
         this.MoveToNextRow();
      }
   }
   public int[] testArrayReturn () //returns a simple array in console
   {      
      int [] arrayToReturn = {0,1,2,3,4,5,6};
      return arrayToReturn;
   }    
}


class HistogramPrinter extends Object 
{ 
   public void printHistogram(int [] Printing)   //prints the array in stars(*) with the same rows
   {
   for(int P =0; P < Printing.length; P++)
      {
      System.out.println("");
      for(int T=0; T < Printing[P]; T++)
         {
         System.out.print("*");
         }
      }    
   }	 
}

public class DrawHistogram extends Object
{
   public static void main(String[] args)
   {
      City c = new City(12, 12);
      HistogramRobot drawingBot = new HistogramRobot(c, 1, 1, Direction.EAST, 1000);
    
      HistogramPrinter histPrinter = new HistogramPrinter();
    
      int [] histogramData = new int[7];  //the Array used
   	
      histogramData[0] = 3;
      histogramData[1] = 5;
      histogramData[2] = 1;
      histogramData[3] = 0;
      histogramData[4] = 4;
      histogramData[5] = 2;
      histogramData[6] = 1;
   
   
   	// Make the robot 'draw' the (horizontal) histogram of Things here
      drawingBot.drawHistogram(histogramData); //one main command to draw
         
      for (int i =0; i<7; i++)   //prints the list of numbers in array
      {
      System.out.print(histogramData[i]);
      }
      
      System.out.println("");	
      histPrinter.printHistogram(histogramData);
      System.out.println("");
      System.out.println("ArrayToReturn: ");
      int [] returnedArray = drawingBot.testArrayReturn (); 
      for (int i=0; i < returnedArray.length; i++) 
         {
         System.out.print(returnedArray[i]);
         }
   		
   }
}
