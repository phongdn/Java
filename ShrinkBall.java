import java.awt.Color;

public class ShrinkBall extends BasicBall {
	private final double minSmallestSize; //Constant Value
	private final double originalSize; //Constant Value
	
	public ShrinkBall(double r, Color c) {
		super(r,c);  //Call Parent Constructor
		minSmallestSize = r/4; //Smallest size possible is 1/4 the size of the original
		originalSize = r;
		name = "shrinkBall";  //Used for determining the most hit ball in Player Class
	}
	
	@Override
    public int reset() {
		super.reset(); //Call superclass reset()
        radius *= 0.66; //It becomes 1/3 smaller (2/3 the original size)
        if(radius < minSmallestSize)  //If less than smallest size, return to original size
        	radius = originalSize;
        return 1;
    }
	
	
	@Override
	public int getScore() {  //Shrink Ball = 20 points
    	return 20;
    }

}
