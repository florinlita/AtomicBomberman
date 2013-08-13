package com.example.bomberman;

import java.util.ArrayList;

public class Game {

	private int numberOfPlayers;
	private ArrayList<Bomberman> bombermans = new ArrayList<Bomberman>();
	private int[][] gameMatrix;
	
	//Variable used for AI
	private double minimum = 1000;
	
	//Constructor
	public Game(int givenPlayers, int[][] givenMatrix)
	{
		numberOfPlayers = givenPlayers;
		gameMatrix = givenMatrix;
		Coordinates[] coord = GameMatrix.bowlingCoordinates(numberOfPlayers);
		for (int i = 0; i < numberOfPlayers; i ++)
			bombermans.add(new Bomberman(coord[i], i));	
	}
	
	//This method returns the total number of players
	public int getNumberOfPlayers()
	{
		return numberOfPlayers;
	}
	
	//This method returns all the existing bombermans of the game
	public ArrayList<Bomberman> getBombermans()
	{
		return bombermans;
	}
	
	//This method returns a bomberman from a given position in the array
	public Bomberman getBomberman(int position)
	{
		return bombermans.get(position);
	}
	
	//This method returns the game matrix
	public int[][] getGameMatrix()
	{
		return gameMatrix;
	}
	
	//These methods update the game matrix
	//These methods get called every time the timer ticks
	public void updateBombermans()
	{
		//For every player in the game update the position of the bomberman, bombs and explosion
		for (int i = 0; i < numberOfPlayers; i ++)
		{
			//System.out.println(bombermans.get(i).getStatus());
			//BOMBERMAN
			//Check the status of the bomberman and action accordingly
			if (bombermans.get(i).getStatus())
			{
				//If the bomberman moved update the cell at the previous and next location
				if (bombermans.get(i).getCurrentCoordinates().compareTo(bombermans.get(i).getPreviousCoordinates()) == -1 
					&& (gameMatrix[bombermans.get(i).getCurrentCoordinates().getX()][bombermans.get(i).getCurrentCoordinates().getY()] == GameMatrix.FREE_CELL
					    || gameMatrix[bombermans.get(i).getCurrentCoordinates().getX()][bombermans.get(i).getCurrentCoordinates().getY()] == GameMatrix.PLAYER1
					    || gameMatrix[bombermans.get(i).getCurrentCoordinates().getX()][bombermans.get(i).getCurrentCoordinates().getY()] == GameMatrix.PLAYER2
					    || gameMatrix[bombermans.get(i).getCurrentCoordinates().getX()][bombermans.get(i).getCurrentCoordinates().getY()] == GameMatrix.PLAYER3
					    || gameMatrix[bombermans.get(i).getCurrentCoordinates().getX()][bombermans.get(i).getCurrentCoordinates().getY()] == GameMatrix.PLAYER4
					    || gameMatrix[bombermans.get(i).getCurrentCoordinates().getX()][bombermans.get(i).getCurrentCoordinates().getY()] == GameMatrix.PLAYER5
					    || gameMatrix[bombermans.get(i).getCurrentCoordinates().getX()][bombermans.get(i).getCurrentCoordinates().getY()] == GameMatrix.PLAYER5))		
				{
					gameMatrix[bombermans.get(i).getPreviousX()][bombermans.get(i).getPreviousY()] = GameMatrix.FREE_CELL;
					gameMatrix[bombermans.get(i).getX()][bombermans.get(i).getY()] = GameMatrix.getBombermanCell(i);
				}
				else
					bombermans.get(i).reverseAction();
			}
			else
				gameMatrix[bombermans.get(i).getPreviousX()][bombermans.get(i).getPreviousY()] = GameMatrix.getBombermanCell(i);
				
		}
	}
	
	//This method updates the bombs in the matrix
	public void updateBombs()
	{
		for (int i = 0; i < numberOfPlayers; i ++)
		{
			int length = (bombermans.get(i).getBombs() != null) ? bombermans.get(i).getBombs().size() : 0;
				
			for (int j = 0; j < length; j++)
			{
				if (!bombermans.get(i).getBomb(j).getStatus())
				{
					if (gameMatrix[bombermans.get(i).getBomb(j).getCoordinates().getX()][bombermans.get(i).getBomb(j).getCoordinates().getY()] == gameMatrix[bombermans.get(i).getCurrentCoordinates().getX()][bombermans.get(i).getCurrentCoordinates().getY()])
						gameMatrix[bombermans.get(i).getBomb(j).getCoordinates().getX()][bombermans.get(i).getBomb(j).getCoordinates().getY()] = GameMatrix.getPlayerAndBomb(i);
					else
						gameMatrix[bombermans.get(i).getBomb(j).getCoordinates().getX()][bombermans.get(i).getBomb(j).getCoordinates().getY()] = GameMatrix.getBombCell(i);
					bombermans.get(i).getBomb(j).decreaseTimer();
					System.out.println(bombermans.get(i).getBomb(j).getTimer());
				}
			}//for
		}//for
	}
	
	public void updateExplosions()
	{		
		//Update the explosion for each bomb of each player
		for (int i = 0; i < numberOfPlayers; i++)
		{
			int[] explosionArray = GameMatrix.getExplosionArray(i);
			
			for (int j = 0; j < bombermans.get(i).getBombs().size(); j++)
			{
				if (bombermans.get(i).getBomb(j).getStatus() && bombermans.get(i).getBomb(j).getExplosion().getTimer() != 0)
				{
					//Epicentre of the bomb
					gameMatrix[bombermans.get(i).getBomb(j).getCoordinates().getX()][bombermans.get(i).getBomb(j).getCoordinates().getY()] = explosionArray[0];
					
					//Update the upper branch of the explosion
					ArrayList<Coordinates> array = bombermans.get(i).getBomb(j).getExplosion().getUp();
					//System.out.println("getUP()");
					for (int k = 0; k < array.size() - 1; k ++)
					{
						//System.out.print(" " + array.get(k).getX() + " " + array.get(k).getY());
						if (explosionCheck(array.get(k).getX(), array.get(k).getY()))
							gameMatrix[array.get(k).getX()][array.get(k).getY()] = explosionArray[1];
					}
					//System.out.println();
					if (explosionCheck(array.get(array.size() - 1).getX(), array.get(array.size() - 1).getY()))
						gameMatrix[array.get(array.size() - 1).getX()][array.get(array.size() - 1).getY()] = explosionArray[5];
						
					//Update the right branch of the explosion
					array = bombermans.get(i).getBomb(j).getExplosion().getRight();
					//System.out.println("getRight()");
					for (int k = 0; k < array.size() - 1; k ++)
					{
						//System.out.print(" " + array.get(k).getX() + " " + array.get(k).getY());
						if (explosionCheck(array.get(k).getX(), array.get(k).getY()))
							gameMatrix[array.get(k).getX()][array.get(k).getY()] = explosionArray[2];
					}
					//System.out.println();
					if (explosionCheck(array.get(array.size() - 1).getX(), array.get(array.size() - 1).getY()))
						gameMatrix[array.get(array.size() - 1).getX()][array.get(array.size() - 1).getY()] = explosionArray[6];
					
					//Update the bottom branch of the explosion
					array = bombermans.get(i).getBomb(j).getExplosion().getDown();
					//System.out.println("getDown()");
					for (int k = 0; k < array.size() - 1; k ++)
					{
						//System.out.print(" " + array.get(k).getX() + " " + array.get(k).getY());
						if (explosionCheck(array.get(k).getX(), array.get(k).getY()))
							gameMatrix[array.get(k).getX()][array.get(k).getY()] = explosionArray[3];
					}
					//System.out.println();
					if (explosionCheck(array.get(array.size() - 1).getX(), array.get(array.size() - 1).getY()))
						gameMatrix[array.get(array.size() - 1).getX()][array.get(array.size() - 1).getY()] = explosionArray[7];
					
					//Update the left branch of the explosion
					array = bombermans.get(i).getBomb(j).getExplosion().getLeft();
					//System.out.println("getLeft()");
					for (int k = 0; k < array.size() - 1; k ++)
					{
						//System.out.print(" " + array.get(k).getX() + " " + array.get(k).getY());
						if (explosionCheck(array.get(k).getX(), array.get(k).getY()))
							gameMatrix[array.get(k).getX()][array.get(k).getY()] = explosionArray[4];
					}
					//System.out.println();
					if (explosionCheck(array.get(array.size() - 1).getX(), array.get(array.size() - 1).getY()))
						gameMatrix[array.get(array.size() - 1).getX()][array.get(array.size() - 1).getY()] = explosionArray[8];
					
					//Update the bomb - make it null
					System.out.println(bombermans.get(i).getBomb(j).getExplosion().getTimer());
					if (bombermans.get(i).getBomb(j).getExplosion().getTimer() == 1)
					{
						//In case the bomb is exploded and the explosion lasted long enough the cells will become free
						//System.out.println("metoda");
						for (int h = 0; h < 15; h ++)
						{
							//System.out.println();
							for (int g = 0; g < 11; g ++)
							{
								if (gameMatrix[h][g] <= GameMatrix.getMax(i) && gameMatrix[h][g] >= GameMatrix.getMin(i))
									gameMatrix[h][g] = GameMatrix.FREE_CELL;
								//System.out.print(gameMatrix[h][g]);
							}
						}
						//bombermans.get(i).updateBomb(j);
					}//if

					bombermans.get(i).getBomb(j).getExplosion().decreaseTimer();
				}//if
				
			}//for
		}//for
	}
	
	//This method gets called each time a bomberman attempts to place a bomb
	public void placeBomb(int playerNumber)
	{
		bombermans.get(playerNumber).placeBomb();
	}
	
	public boolean explosionCheck(int givenX, int givenY)
	{
		for (int l = 0; l < bombermans.size(); l ++)
			if (gameMatrix[givenX][givenY] == GameMatrix.getBombermanCell(l))
				bombermans.get(l).updateStatus();
		if (gameMatrix[givenX][givenY] == GameMatrix.BRICK)
			return false;
		else
			return true;
	}
	
	public void moveUp(int position)
	{
		bombermans.get(position).moveUp();
	}
	public void moveDown(int position)
	{
		bombermans.get(position).moveDown();
	}
	public void moveLeft(int position)
	{
		bombermans.get(position).moveLeft();
	}
	public void moveRight(int position)
	{
		bombermans.get(position).moveRight();
	}
	
	public void moveArtificialBomberman()
	{
		Coordinates bombermanCoord, coord;
		
		//Attempt to place a bomb
		if (minimum < 4 && minimum < bombermans.get(1).getBombPower())
		{
			bombermans.get(1).placeBomb();
		}
		bombermanCoord = new Coordinates(bombermans.get(1).getCurrentCoordinates().getX(), bombermans.get(1).getCurrentCoordinates().getY());
		coord = Coordinates.computeCoordinates(bombermanCoord, 0);
		
		
		//Get the smallest distance between bombermans from all 4 directions
		/*for (int i = 1; i < 4; i ++)
		{
			coord = Coordinates.computeCoordinates(bombermanCoord, i);
			double temp = Math.sqrt(
					(bombermans.get(0).getCurrentCoordinates().getX() - coord.getX()) * (bombermanCoord.getX() - coord.getX()))
					+ (bombermans.get(0).getCurrentCoordinates().getY() - coord.getY() * (bombermanCoord.getY() - coord.getY()));
			if (temp < minimum)
				minimum = temp;
			System.out.println("distance = " + minimum);
		}
		System.out.println(coord.getX() + " " + coord.getY());
		
		//Find the minimum and move the bomberman
		for (int i = 0; i < 4; i ++)
		{
			coord = Coordinates.computeCoordinates(bombermanCoord, i);
			double temp = Math.sqrt(
					(bombermans.get(0).getCurrentCoordinates().getX() - coord.getX()) * (bombermanCoord.getX() - coord.getX()))
					+ (bombermans.get(0).getCurrentCoordinates().getY() - coord.getY() * (bombermanCoord.getY() - coord.getY()));
			if (temp == minimum)
			{
				System.out.println("for2");
				System.out.println(bombermans.get(i).getCurrentCoordinates().getX() + " " + bombermans.get(i).getCurrentCoordinates().getY());
				System.out.println("bomberman var");
				System.out.println(bombermanCoord.getX() + " " + bombermanCoord.getY());
				bombermans.get(1).moveDirection(i);
				
				break;
			}
		}*/
	}
}
