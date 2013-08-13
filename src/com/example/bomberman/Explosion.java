package com.example.bomberman;

import java.util.ArrayList;

public class Explosion {

	private Coordinates coordinate;
	private int power;
	private boolean isShown = false;
	//the number of miliseconds the explosion will be on the screen
	private int timer = 10;
	
	
	//Constructor
	public Explosion(int givenPower, Coordinates givenCoordinate)
	{
		coordinate = givenCoordinate;
		power = givenPower;
	}
	
	//Methods to access the object variables
	public int getPower()
	{
		return power;
	}
	public Coordinates getCoordinates()
	{
		return coordinate;
	}
	
	public boolean getStatus()
	{
		return isShown;
	}
	
	public void changeStatus()
	{
		isShown = true;
	}
	
	public int getTimer()
	{
		return timer;
	}
	
	public void decreaseTimer()
	{
		timer --;
	}
	
	//This method returns the coordinates of the upper flame
	public ArrayList<Coordinates> getUp()
	{
		int temp1 = (coordinate.getY() != 0) ? coordinate.getY() - 1 : 0;
		ArrayList<Coordinates> coordinates = new ArrayList<Coordinates>();
		for (int i = 0; i < power && i <= temp1; i ++)
			coordinates.add(new Coordinates(coordinate.getX(), temp1 - i));
		return coordinates;
	}
	public ArrayList<Coordinates> getDown()
	{
		int temp1 = (coordinate.getY() != 10) ? coordinate.getY() + 1 : 10;
		ArrayList<Coordinates> coordinates = new ArrayList<Coordinates>();
		for (int i = 0; i < power && (i + temp1) <= 10; i ++)
			coordinates.add(new Coordinates(coordinate.getX(), temp1 + i));
		return coordinates;
	}
	public ArrayList<Coordinates> getLeft()
	{
		int temp1 = (coordinate.getX() != 0) ? coordinate.getX() - 1 : 0;
		ArrayList<Coordinates> coordinates = new ArrayList<Coordinates>();
		for (int i = 0; i < power && i <= temp1; i ++)
			coordinates.add(new Coordinates(temp1 - i, coordinate.getY()));
		return coordinates;
	}
	public ArrayList<Coordinates> getRight()
	{
		int temp1 = (coordinate.getX() != 14 ) ? coordinate.getX() + 1 : 14;
		ArrayList<Coordinates> coordinates = new ArrayList<Coordinates>();
		for (int i = 0; i < power && (i + temp1) <= 14; i ++)
			coordinates.add(new Coordinates(temp1 + i, coordinate.getY()));
		return coordinates;
	}
}
