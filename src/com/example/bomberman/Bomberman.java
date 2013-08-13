package com.example.bomberman;

import java.util.ArrayList;

import android.util.Log;

public class Bomberman {

	//The previous and current coordinates of the bomberman
	private Coordinates coordinate, previousCoordinate;
	//The direction of the bomberman
	private int direction;
	//The status of the bomberman
	private boolean isAlive;
	//The number of the bomberman
	private int playerNumber;
	
	
	//The total number of bombs allowed for the bomberman
	private int numberOfBombs;
	//The number of the remaining bombs of the bomberman
	private int remainingBombs;
	//The array of the bombs created by the bomberman
	private ArrayList<Bomb> bombs = new ArrayList<Bomb>();
	//The power of the bomb
	//The number represents the cells in either N/S/W/E continuing the flame
	private int bombPower = 2;
	
	
	//Constructor
	public Bomberman(Coordinates givenCoordinate, int givenPlayerNumber)
	{
		coordinate = givenCoordinate;
		previousCoordinate = new Coordinates(0,0);
		previousCoordinate.updateX(coordinate.getX());
		previousCoordinate.updateY(coordinate.getY());
		direction = Direction.EAST;
		isAlive = true;
		numberOfBombs = remainingBombs = 100;
		//bombs = new Bomb[numberOfBombs];
		playerNumber = givenPlayerNumber;
	}
	
	//These 2 methods return the coordinates of the bomberman
	public int getX()
	{
		return coordinate.getX();
	}
	public int getY()
	{
		return coordinate.getY();
	}
	public Coordinates getCurrentCoordinates()
	{
		return coordinate;
	}
	
	//These 2 methods return the previous coordinates of the bomberman
	public int getPreviousX()
	{
		return previousCoordinate.getX();
	}
	public int getPreviousY()
	{
		return previousCoordinate.getY();
	}
	public Coordinates getPreviousCoordinates()
	{
		return previousCoordinate;
	}
	
	//This method updates the direction of the bomberman
	public void updateDirection (int givenDirection)
	{
		direction = givenDirection;
	}
	//This method returns the direction of the bomberman
	public int getDirection()
	{
		return direction;
	}
	
	//This method returns if the bomberman is alive or not
	public boolean getStatus()
	{
		return isAlive;
	}
	//This methods updates the status of the bomberman: dead or alive
	public void updateStatus()
	{
		isAlive = false;
	}
	
	//This method returns the number of the player(the number of the Bomberman)
	public int getNumber()
	{
		return playerNumber;
	}
	
	//This method returns the total number of the bombs of the bomberman
	public int getTotalBombs()
	{
		return numberOfBombs;
	}
	public int getBombPower()
	{
		return bombPower;
	}
	//This method returns the bomb array of the bomberman
	public ArrayList<Bomb> getBombs()
	{
		return bombs;
	}
	//This method returns the bomb at a given position
	public Bomb getBomb(int position)
	{
		return bombs.get(position);
	}
	
	public void moveDirection(int direction)
	{
		switch(direction)
		{
			case Direction.NORTH: moveUp();
			case Direction.SOUTH: moveDown();
			case Direction.WEST: moveLeft();
			case Direction.EAST: moveRight();
		}
	}
	
	//These methods update the coordinates of the bomberman
	public void moveUp()
	{
		previousCoordinate.updateX(coordinate.getX());
		previousCoordinate.updateY(coordinate.getY());
		if (coordinate.getY() != 0)
			coordinate.updateY(coordinate.getY() - 1);
		direction = Direction.NORTH;
		Log.println (Log.DEBUG, "exemplu log", previousCoordinate.getX() + " " + previousCoordinate.getY() + " " + coordinate.getX() + " " + coordinate.getY());
	}
	public void moveDown()
	{
		previousCoordinate.updateX(coordinate.getX());
		previousCoordinate.updateY(coordinate.getY());
		if (coordinate.getY() != 10)
			coordinate.updateY(coordinate.getY() + 1);
		direction = Direction.SOUTH;
		Log.println (Log.DEBUG, "exemplu log", previousCoordinate.getX() + " " + previousCoordinate.getY() + " " + coordinate.getX() + " " + coordinate.getY());
	}
	public void moveRight()
	{
		previousCoordinate.updateX(coordinate.getX());
		previousCoordinate.updateY(coordinate.getY());
		if (coordinate.getX() != 14)
			coordinate.updateX(coordinate.getX() + 1);
		direction = Direction.EAST;
		Log.println (Log.DEBUG, "exemplu log", previousCoordinate.getX() + " " + previousCoordinate.getY() + " " + coordinate.getX() + " " + coordinate.getY());
	}
	public void moveLeft()
	{
		previousCoordinate.updateX(coordinate.getX());
		previousCoordinate.updateY(coordinate.getY());
		if (coordinate.getX() != 0)
			coordinate.updateX(coordinate.getX() - 1);
		direction = Direction.WEST;
		Log.println (Log.DEBUG, "exemplu log", previousCoordinate.getX() + " " + previousCoordinate.getY() + " " + coordinate.getX() + " " + coordinate.getY());
	}
	
	public void reverseAction()
	{
		coordinate.updateX(previousCoordinate.getX());
		coordinate.updateY(previousCoordinate.getY());
	}
	
	//Methods regarding bombs
	public void placeBomb()
	{
		if (remainingBombs != 0)
		{
			remainingBombs --;
			bombs.add(new Bomb(Direction.computeCoordinates(direction, coordinate), bombPower));
		}
	}
	
	public void updateBomb(int position)
	{
		bombs.remove(position);
	}
}
