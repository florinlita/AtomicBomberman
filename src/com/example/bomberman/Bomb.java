package com.example.bomberman;

public class Bomb {
	
	private Coordinates coordinate;
	private int timer;
	private int power;
	private boolean isExploded = false;
	private Explosion explosion;
	
	public Bomb(Coordinates givenCoordinates, int givenPower)
	{
		coordinate = givenCoordinates;
		timer = 20;
		power = givenPower;
	}
	
	//Access methods for the Bomb object
	public int getTimer()
	{
		return timer;
	}
	public Coordinates getCoordinates()
	{
		return coordinate;
	}
	public int getPower()
	{
		return power;
	}
	public boolean getStatus()
	{
		return isExploded;
	}
	public Explosion getExplosion()
	{
		return explosion;
	}
	
	public void decreaseTimer()
	{
		if (timer != 0)
			timer --; 
		else
		{
			isExploded = true;
			explosion = new Explosion(power, coordinate);
		}
	}	
}
