import java.awt.Color;

public class SplitBall extends BasicBall {
	public SplitBall(double r, Color c) {
		super(r,c);   //Call Parent Constructor
		name = "splitBall";   //Used for determining the most hit ball in Player Class
	}
	
	@Override
	public int getScore() {  //Split Ball = 10 points
    	return 10;
    }
}
