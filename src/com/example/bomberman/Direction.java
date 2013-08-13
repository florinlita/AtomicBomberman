package com.example.bomberman;

public class Direction
{
	//This gives the direction the Bomberman is facing and also provides methods to alter it
	public static final int NORTH = 1;
	public static final int EAST = 2;
	public static final int SOUTH = 3;
	public static final int WEST = 4;

	public static int turnLeft()
	{
		return WEST;
	} // turnLeft
	
	public static int turnRight()
	{
		return EAST;
	} // turnRight
	
	public static int turnUp()
	{
		return NORTH;
	} // turnUp
	
	public static int turnDown()
	{
		return SOUTH;
	} // turnDown
	
	public static Coordinates computeCoordinates(int direction, Coordinates coord)
	{
		switch (direction)
		{
		case NORTH: return new Coordinates(coord.getX(), coord.getY() - 1);
		case SOUTH: return new Coordinates(coord.getX(), coord.getY() + 1);
		case WEST: return new Coordinates(coord.getX() - 1, coord.getY());
		case EAST: return new Coordinates(coord.getX() + 1, coord.getY());
		default: return coord;
		}
		 
	}
} // class Direction
	