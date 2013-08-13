package com.example.bomberman;

public class Coordinates implements Comparable<Coordinates>
{
	//This class holds the coordinates of the bombermans
	private int xCoord;
	private int yCoord;
	
	//Constructor
	public Coordinates(int givenX, int givenY)
	{
		xCoord = givenX;
		yCoord = givenY;
	}
	
	//These methods return the X or Y coordinate
	public int getX()
	{
		return xCoord;
	}
	public int getY()
	{
		return yCoord;
	}
	
	//These methods update the X or Y coordinate
	public void updateX(int givenX)
	{
		xCoord = givenX;
	}
	public void updateY(int givenY)
	{
		yCoord = givenY;
	}
	
	public static Coordinates computeCoordinates(Coordinates coord, int direction)
	{
		switch (direction)
		{
			case Direction.NORTH: 
				coord.updateY(coord.getY() - 1);
				return new Coordinates(coord.getX(), coord.getY());
			case Direction.SOUTH:
				coord.updateY(coord.getY() + 1);
				return new Coordinates(coord.getX(), coord.getY());
			case Direction.EAST:
				coord.updateY(coord.getX() + 1);
				return new Coordinates(coord.getX(), coord.getY());
			case Direction.WEST:
				coord.updateY(coord.getX() - 1);
				return new Coordinates(coord.getX(), coord.getY());
			default: return coord;
		}
		
	}
	
	@Override
	public int compareTo(Coordinates another) {
		// TODO Auto-generated method stub
		if (xCoord == another.getX() && yCoord == another.getY())
			return 0;
		else
			return -1;
			
	}
}