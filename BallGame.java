/******************************************************************************
 *  Compilation:  javac BallGame.java
 *  Execution:    java BallGame n
 *  Dependencies: BasicBall.java StdDraw.java
 *  
 *  By: Phong Nguyen
 *  IDE: Eclipse
 *  OS: Windows 10 x64
 *
 *  Creates a BasicBall and animates it
 *
 *  Part of the animation code is adapted from Computer Science:   An Interdisciplinary Approach Book
 *  
 *  Run the skeleton code with arguments : 1  basic  0.08
 *******************************************************************************/
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

public class BallGame { 

    public static void main(String[] args) {
    	
  
    	// number of bouncing balls
    	int numBalls = Integer.parseInt(args[0]);
    	//ball types
    	String ballTypes[] = new String[numBalls];
    	//sizes of balls
    	double ballSizes[] = new double[numBalls];
    	
    	//Error handling for bad arguments
    	if( (numBalls*2) + 1 > args.length || numBalls < 0 || args.length < 3) {
    		System.out.printf("Bad arguments. Please Fix!");   //Prints error message
    		return; //Skips code below
    	}
    	
    	
    	//retrieve ball types
    	int index =1;
    	for (int i=0; i<numBalls; i++) {
    		ballTypes[i] = args[index];   //Array of ball types
    		index = index+2;
    	}
    	
    	//retrieve ball sizes
    	index = 2;
    	for (int i=0; i<numBalls; i++) {
    		try {   //Error Handling
    			ballSizes[i] = Double.parseDouble(args[index]);   //If Argument is not a double value
    			index = index+2;
    		}
    		catch(NumberFormatException e) {
    			System.out.printf("Bad arguments. Please Fix!");   //Print Error Message
        		return; //Skips code below
    		}
    	}
       
    	Player player1 = new Player(); //Player Class initialized with starting stats
    	
    	//number of active balls
    	int numBallsinGame = 0;
        StdDraw.enableDoubleBuffering();

        StdDraw.setCanvasSize(800, 800);
        // set boundary to box with coordinates between -1 and +1
        StdDraw.setXscale(-1.0, +1.0);
        StdDraw.setYscale(-1.0, +1.0);

        
        ArrayList<BasicBall> listOfBalls = new ArrayList<BasicBall>(30);
        
        for(int i = 0; i < numBalls; i++)   //Creates a ball based on the array of types
        {
        	if("basic".equals(ballTypes[i]))
        		listOfBalls.add(new BasicBall(ballSizes[i],Color.RED));
        	else if("bounce".equals(ballTypes[i]))
        		listOfBalls.add(new BounceBall(ballSizes[i],Color.BLUE));
        	else if("split".equals(ballTypes[i]))
        		listOfBalls.add(new SplitBall(ballSizes[i],Color.YELLOW));
        	else if("shrink".equals(ballTypes[i]))
        		listOfBalls.add(new ShrinkBall(ballSizes[i],Color.GREEN));
        	else {   //String isn't one of these types. Bad Argument
        		System.out.printf("Error in ballTypes array. Please Check Arguments");  //Error Message
        		StdDraw.setPenColor(StdDraw.RED);
                Font font = new Font("Arial", Font.BOLD, 30);
                StdDraw.setFont(font);
                StdDraw.text(0, 0, "Bad Arguments. Please Fix!");  //Error Message
                StdDraw.show();
                StdDraw.pause(20);
        		return;
        	}
        	numBallsinGame++;
        		
        }
        
        // do the animation loop
        StdDraw.enableDoubleBuffering();
        while (numBallsinGame > 0) {

            for(int i = 0; i < listOfBalls.size(); i++) { //Moves all the ball objects
            	(listOfBalls.get(i)).move();
            }

            //Check if the mouse is clicked
            if (StdDraw.isMousePressed()) {
                double x = StdDraw.mouseX();
                double y = StdDraw.mouseY();
                int temp = listOfBalls.size(); //Avoid infinite loop error when we keep adding new split ball
            	for(int k = 0; k < temp; k++) { //Checks if any of the split balls were hit
                	if(listOfBalls.get(k).isHit(x,y)) {
                		listOfBalls.get(k).reset();
                		player1.updateScore(listOfBalls.get(k).getName(), listOfBalls.get(k).getScore());
                		if(listOfBalls.get(k) instanceof SplitBall) {  //If it is a splitball, do this
	                		listOfBalls.add(new SplitBall(listOfBalls.get(k).getRadius(),Color.YELLOW));  //All Split balls will be yellow
	                		numBallsinGame++;
                		}
                	}
                }
                
            }
                
            numBallsinGame = 0;
            // draw the n balls
            StdDraw.clear(StdDraw.GRAY);
            StdDraw.setPenColor(StdDraw.BLACK);
            
 
            for(int p = 0; p < listOfBalls.size(); p++) //Draw all the balls
            {
            	if(listOfBalls.get(p).isOut == false) {
            		(listOfBalls.get(p)).draw();
                	numBallsinGame++;
                }
            }
            //Print the game progress
            StdDraw.setPenColor(StdDraw.YELLOW);
            Font font = new Font("Arial", Font.BOLD, 20);
            StdDraw.setFont(font);
            StdDraw.text(-0.65, 0.90, "Number of balls in game: "+ String.valueOf(numBallsinGame));
            StdDraw.text(-0.71, 0.80, "Number of balls hit: "+ String.valueOf(player1.getNumHits()));
            StdDraw.text(-0.78, 0.70, "Total Score: "+ String.valueOf(player1.getScore()));
            StdDraw.text(-0.68, 0.60, "Most Hit Ball: " + player1.getMostHitBall());

            StdDraw.show();
            StdDraw.pause(20);
        }
        while (true) {
            StdDraw.setPenColor(StdDraw.BLUE);
            Font font = new Font("Arial", Font.BOLD, 60);
            StdDraw.setFont(font);
            StdDraw.text(0, 0, "GAME OVER");
            StdDraw.show();
            StdDraw.pause(10);           
        }
        	
        
    }
}
