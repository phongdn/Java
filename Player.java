
public class Player {
	private int numHits, basicBall, shrinkBall, bounceBall, splitBall;
	private int score;
	private String mostHitBall;
	
	public Player(){
		score = numHits = basicBall = shrinkBall = bounceBall = splitBall = 0; //Initializing all of these variables to 0
		mostHitBall = "None"; //None
	}
	
	public void updateScore(String typeOfBall, int points){   //Updates score and each ball's number of hits
		if(typeOfBall == "basicBall")
			basicBall++;
		else if(typeOfBall == "shrinkBall") 
			shrinkBall++;
		else if(typeOfBall == "bounceBall") 
			bounceBall++;
		else  //SplitBall
			splitBall++;	
		score += points;
		updateHits();  
	}
	
	private void updateHits()
	{
		numHits++;
	}
	
	public int getNumHits() {
		return numHits;
	}
	
	public int getScore() {
		return score;
	}
	
	private void updateMostHitBall() { //Checks to see which is the most hit ball
		if( (basicBall > shrinkBall) && (basicBall > bounceBall) && (basicBall > splitBall))
			mostHitBall = "basicBall";
		else if( (shrinkBall > bounceBall) && (shrinkBall > splitBall) )
			mostHitBall = "shrinkBall";
		else if(bounceBall > splitBall)
			mostHitBall = "bounceBall";
		else if(basicBall == 0 && bounceBall == 0 && splitBall == 0 && shrinkBall == 0) //Player doesn't hit a single ball
			mostHitBall = "None";
		else
			mostHitBall = "splitBall";
	}
	
	public String getMostHitBall() {
		updateMostHitBall(); //Only update when we need to get the most hit ball for better runtime
		return mostHitBall;
	}
	
}
