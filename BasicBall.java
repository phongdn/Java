/******************************************************************************
 *  Compilation:  javac ColoredBall.java
 *  Execution:    java ColoredBall
 *  Dependencies: StdDraw.java
 *
 *  Implementation of a 2-d ball moving in square with coordinates
 *  between -1 and +1. Bounces off the walls upon collision.
 *  
 *
 ******************************************************************************/

import java.awt.Color;

public class BasicBall { 
    protected double rx, ry;         // position
    protected double vx, vy;         // velocity
    protected double radius;   // radius
    protected final Color color;     // color
    public boolean isOut;
    protected String name;
    

    // constructor
    public BasicBall(double r, Color c) {
        rx = 0.0;
        ry = 0.0;
        vx = StdRandom.uniform(-0.015, 0.015);
        vy = StdRandom.uniform(-0.015, 0.015);
        radius = r;
        color = c;
        isOut = false;
        name = "basicBall";  //Used for determining the most hit ball in Player Class
    }
   
   
    // move the ball one step
    public void move() {
        rx = rx + vx;
        ry = ry + vy;
        if ((Math.abs(rx) > 1.0) || (Math.abs(ry) > 1.0)) 
        	isOut = true;
    }

    // draw the ball
    public void draw() { 
    	if ((Math.abs(rx) <= 1.0) && (Math.abs(ry) <= 1.0)) {
    		StdDraw.setPenColor(color);
    		StdDraw.filledCircle(rx, ry, radius);
    	} else
    		isOut = true;
    	
    }
    
    // reset ball back to center with random speed
    public int reset() {
        rx = 0.0;
        ry = 0.0;  	
        vx = StdRandom.uniform(-0.015, 0.015); //assinging random speed
        vy = StdRandom.uniform(-0.015, 0.015);
        return 1;
    }
    
    public boolean isHit(double x, double y) {
    	if ((Math.abs(rx-x)<=radius) && (Math.abs(ry-y)<=radius))
			return true;
		else return false; 

    }
    public int getScore() {   //Basic Ball = 25 points
    	return 25;
    }
    
    public double getRadius() {
    	return radius;
    }
    
    public String getName() {
    	return name;
    }


}
