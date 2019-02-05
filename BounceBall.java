import java.awt.Color;

public class BounceBall extends BasicBall{
	private int numTimesHitWall;
	private final int maxNumBounces;
	
	public BounceBall(double r, Color c) {
		super(r,c);  //Call Parent Constructor
		numTimesHitWall = 0;
		maxNumBounces = 3;
		name = "bounceBall";   //Used for determining the most hit ball in Player Class
	}
	
	private void updatetimesHitWall() {  //Increment number of times bounce ball bounces from wall
		numTimesHitWall ++;
	}
	
	@Override
	public void move() {
        rx = rx + vx;
        ry = ry + vy;
        if (((Math.abs(rx) > 1.0) || (Math.abs(ry) > 1.0)) && numTimesHitWall >= maxNumBounces) 
        	isOut = true;
        else if(Math.abs(rx) >= 0.95 && numTimesHitWall < maxNumBounces){
        	vx = -vx;
        	rx = rx+vx;
        	updatetimesHitWall();
        }
        else if(Math.abs(ry) >= 0.95 && numTimesHitWall < maxNumBounces){
        	vy = -vy;
        	ry = ry+vy;
        	updatetimesHitWall();
        }
    }
	
	//BounceBall will not reset numTimesHitWall when hit, as mentioned by instructor.
	
	@Override
	public int getScore() {   //Bounce Ball = 15 points
    	return 15;
    }
}
