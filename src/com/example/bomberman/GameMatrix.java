package com.example.bomberman;

public class GameMatrix {
	
	//Environment cells:
	//If the cell is 0 than it is a FREE CELL
	//If the cell is 1 than it is a non-destructible BRICK
	//If the cell is 2 than it is a destructible BRICK
	public static int FREE_CELL = 0;
	public static int BRICK = 1;
	public static int DESTRUCTIBLE_BRICK = 2;
	
	//Player cells:
	//If the cell is 10 than it is player1
	//If the cell is 11 than it is player2
	//If the cell is 12 than it is player3
	//If the cell is 13 than it is player4
	//If the cell is 14 than it is player5
	//If the cell is 15 than it is player6
	public static int PLAYER1 = 10;
	public static int PLAYER2 = 11;
	public static int PLAYER3 = 12;
	public static int PLAYER4 = 13;
	public static int PLAYER5 = 14;
	public static int PLAYER6 = 15;
	
	//Bomb cells:
	//If the cell is 20 than it belongs to player1
	//If the cell is 21 than it belongs to player2
	//If the cell is 22 than it belongs to player3
	//If the cell is 23 than it belongs to player4
	//If the cell is 24 than it belongs to player5
	//If the cell is 25 than it belongs to player6
	public static int BOMB_PLAYER1 = 20;
	public static int BOMB_PLAYER2 = 21;
	public static int BOMB_PLAYER3 = 22;
	public static int BOMB_PLAYER4 = 23;
	public static int BOMB_PLAYER5 = 24;
	public static int BOMB_PLAYER6 = 25;
	
	//Explosion cells
	//Player1
	public static int EXPLOSION_CENTER_PLAYER1 = 30;
	public static int EXPLOSION_MIDDLE_UP_PLAYER1 = 31;
	public static int EXPLOSION_MIDDLE_RIGHT_PLAYER1 = 32;
	public static int EXPLOSION_MIDDLE_DOWN_PLAYER1 = 33;
	public static int EXPLOSION_MIDDLE_LEFT_PLAYER1 = 34;
	public static int EXPLOSION_TERMINAL_UP_PLAYER1 = 35;
	public static int EXPLOSION_TERMINAL_RIGHT_PLAYER1 = 36;
	public static int EXPLOSION_TERMINAL_DOWN_PLAYER1 = 37;
	public static int EXPLOSION_TERMINAL_LEFT_PLAYER1 = 38;
	public static int[] PLAYER1_EXPLOSIONS = {EXPLOSION_CENTER_PLAYER1,
												EXPLOSION_MIDDLE_UP_PLAYER1,
												EXPLOSION_MIDDLE_RIGHT_PLAYER1,
												EXPLOSION_MIDDLE_DOWN_PLAYER1,
												EXPLOSION_MIDDLE_LEFT_PLAYER1,
												EXPLOSION_TERMINAL_UP_PLAYER1,
												EXPLOSION_TERMINAL_RIGHT_PLAYER1,
												EXPLOSION_TERMINAL_DOWN_PLAYER1,
												EXPLOSION_TERMINAL_LEFT_PLAYER1};
	
	//Player2
	public static int EXPLOSION_CENTER_PLAYER2 = 40;
	public static int EXPLOSION_MIDDLE_UP_PLAYER2 = 41;
	public static int EXPLOSION_MIDDLE_RIGHT_PLAYER2 = 42;
	public static int EXPLOSION_MIDDLE_DOWN_PLAYER2 = 43;
	public static int EXPLOSION_MIDDLE_LEFT_PLAYER2 = 44;
	public static int EXPLOSION_TERMINAL_UP_PLAYER2 = 45;
	public static int EXPLOSION_TERMINAL_RIGHT_PLAYER2 = 46;
	public static int EXPLOSION_TERMINAL_DOWN_PLAYER2 = 47;
	public static int EXPLOSION_TERMINAL_LEFT_PLAYER2 = 48;
	public static int[] PLAYER2_EXPLOSIONS = {EXPLOSION_CENTER_PLAYER2,
												EXPLOSION_MIDDLE_UP_PLAYER2,
												EXPLOSION_MIDDLE_RIGHT_PLAYER2,
												EXPLOSION_MIDDLE_DOWN_PLAYER2,
												EXPLOSION_MIDDLE_LEFT_PLAYER2,
												EXPLOSION_TERMINAL_UP_PLAYER2,
												EXPLOSION_TERMINAL_RIGHT_PLAYER2,
												EXPLOSION_TERMINAL_DOWN_PLAYER2,
												EXPLOSION_TERMINAL_LEFT_PLAYER2};
	
	//Player3
	public static int EXPLOSION_CENTER_PLAYER3 = 50;
	public static int EXPLOSION_MIDDLE_UP_PLAYER3 = 51;
	public static int EXPLOSION_MIDDLE_RIGHT_PLAYER3 = 52;
	public static int EXPLOSION_MIDDLE_DOWN_PLAYER3 = 53;
	public static int EXPLOSION_MIDDLE_LEFT_PLAYER3 = 54;
	public static int EXPLOSION_TERMINAL_UP_PLAYER3 = 55;
	public static int EXPLOSION_TERMINAL_RIGHT_PLAYER3 = 56;
	public static int EXPLOSION_TERMINAL_DOWN_PLAYER3 = 57;
	public static int EXPLOSION_TERMINAL_LEFT_PLAYER3 = 58;
	public static int[] PLAYER3_EXPLOSIONS = {EXPLOSION_CENTER_PLAYER3,
												EXPLOSION_MIDDLE_UP_PLAYER3,
												EXPLOSION_MIDDLE_RIGHT_PLAYER3,
												EXPLOSION_MIDDLE_DOWN_PLAYER3,
												EXPLOSION_MIDDLE_LEFT_PLAYER3,
												EXPLOSION_TERMINAL_UP_PLAYER3,
												EXPLOSION_TERMINAL_RIGHT_PLAYER3,
												EXPLOSION_TERMINAL_DOWN_PLAYER3,
												EXPLOSION_TERMINAL_LEFT_PLAYER3};
	
	//Player4
	public static int EXPLOSION_CENTER_PLAYER4 = 60;
	public static int EXPLOSION_MIDDLE_UP_PLAYER4 = 61;
	public static int EXPLOSION_MIDDLE_RIGHT_PLAYER4 = 62;
	public static int EXPLOSION_MIDDLE_DOWN_PLAYER4 = 63;
	public static int EXPLOSION_MIDDLE_LEFT_PLAYER4 = 64;
	public static int EXPLOSION_TERMINAL_UP_PLAYER4 = 65;
	public static int EXPLOSION_TERMINAL_RIGHT_PLAYER4 = 66;
	public static int EXPLOSION_TERMINAL_DOWN_PLAYER4 = 67;
	public static int EXPLOSION_TERMINAL_LEFT_PLAYER4 = 68;
	public static int[] PLAYER4_EXPLOSIONS = {EXPLOSION_CENTER_PLAYER4,
												EXPLOSION_MIDDLE_UP_PLAYER4,
												EXPLOSION_MIDDLE_RIGHT_PLAYER4,
												EXPLOSION_MIDDLE_DOWN_PLAYER4,
												EXPLOSION_MIDDLE_LEFT_PLAYER4,
												EXPLOSION_TERMINAL_UP_PLAYER4,
												EXPLOSION_TERMINAL_RIGHT_PLAYER4,
												EXPLOSION_TERMINAL_DOWN_PLAYER4,
												EXPLOSION_TERMINAL_LEFT_PLAYER4};
	
	//Player5
	public static int EXPLOSION_CENTER_PLAYER5 = 70;
	public static int EXPLOSION_MIDDLE_UP_PLAYER5 = 71;
	public static int EXPLOSION_MIDDLE_RIGHT_PLAYER5 = 72;
	public static int EXPLOSION_MIDDLE_DOWN_PLAYER5 = 73;
	public static int EXPLOSION_MIDDLE_LEFT_PLAYER5 = 74;
	public static int EXPLOSION_TERMINAL_UP_PLAYER5 = 75;
	public static int EXPLOSION_TERMINAL_RIGHT_PLAYER5 = 76;
	public static int EXPLOSION_TERMINAL_DOWN_PLAYER5 = 77;
	public static int EXPLOSION_TERMINAL_LEFT_PLAYER5 = 78;
	public static int[] PLAYER5_EXPLOSIONS = {EXPLOSION_CENTER_PLAYER5,
												EXPLOSION_MIDDLE_UP_PLAYER5,
												EXPLOSION_MIDDLE_RIGHT_PLAYER5,
												EXPLOSION_MIDDLE_DOWN_PLAYER5,
												EXPLOSION_MIDDLE_LEFT_PLAYER5,
												EXPLOSION_TERMINAL_UP_PLAYER5,
												EXPLOSION_TERMINAL_RIGHT_PLAYER5,
												EXPLOSION_TERMINAL_DOWN_PLAYER5,
												EXPLOSION_TERMINAL_LEFT_PLAYER5};
	
	//Player6
	public static int EXPLOSION_CENTER_PLAYER6 = 80;
	public static int EXPLOSION_MIDDLE_UP_PLAYER6 = 81;
	public static int EXPLOSION_MIDDLE_RIGHT_PLAYER6 = 82;
	public static int EXPLOSION_MIDDLE_DOWN_PLAYER6 = 83;
	public static int EXPLOSION_MIDDLE_LEFT_PLAYER6 = 84;
	public static int EXPLOSION_TERMINAL_UP_PLAYER6 = 85;
	public static int EXPLOSION_TERMINAL_RIGHT_PLAYER6 = 86;
	public static int EXPLOSION_TERMINAL_DOWN_PLAYER6 = 87;
	public static int EXPLOSION_TERMINAL_LEFT_PLAYER6 = 88;
	public static int[] PLAYER6_EXPLOSIONS = {EXPLOSION_CENTER_PLAYER6,
												EXPLOSION_MIDDLE_UP_PLAYER6,
												EXPLOSION_MIDDLE_RIGHT_PLAYER6,
												EXPLOSION_MIDDLE_DOWN_PLAYER6,
												EXPLOSION_MIDDLE_LEFT_PLAYER6,
												EXPLOSION_TERMINAL_UP_PLAYER6,
												EXPLOSION_TERMINAL_RIGHT_PLAYER6,
												EXPLOSION_TERMINAL_DOWN_PLAYER6,
												EXPLOSION_TERMINAL_LEFT_PLAYER6};
	
	public static int BOMB_AND_PLAYER1 = 90;
	public static int BOMB_AND_PLAYER2 = 91;
	public static int BOMB_AND_PLAYER3 = 92;
	public static int BOMB_AND_PLAYER4 = 93;
	public static int BOMB_AND_PLAYER5 = 94;
	public static int BOMB_AND_PLAYER6 = 95;
	
	//Game matrix
	private static int[][] gameMatrix;
	//Player array
	private static int[] a = {10, 0, 0, 0, 0, 0};
	
	public static int[][] bowlingScheme(int numberOfPlayers)
	{
		for (int i = 1; i < a.length; i ++)
			if (i < numberOfPlayers)
				a[i] = i + 10;
		
		gameMatrix = new int[][] { 
				{0, 0, 0, 0, 0, a[0], 0, 0, 0, 0, 0}, //column 0
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //column 1
				{2, 2, 1, 0, 0, 0, 0, 0, 1, 2, 2}, //column 2
				{2, 2, 1, 0, 0, 0, 0, 0, 1, 2, 2}, //column 3
				{2, 2, 1, 0, 0, 0, 0, 0, 1, 2, 2}, //column 4
				{2, 2, 1, 0, 0, 0, 0, 0, 1, 2, 2}, //column 5
				{2, 2, 1, 0, 0, 0, 0, 0, 1, 2, 2}, //column 6
				{2, 2, 1, 0, 0, 0, 0, 0, 1, 2, 2}, //column 7
				{2, 2, 1, 0, 0, 0, 0, 0, 1, 2, 2}, //column 8
				{2, 2, 1, a[2], 0, 0, 0, a[1], 1, 2, 2}, //column 9
				{2, 2, 1, 0, 0, 0, 0, 0, 1, 2, 2}, //column 10
				{2, 2, 1, a[3], 0, 0, 0, a[4], 1, 2, 2}, //column 11
				{2, 2, 1, 0, 0, 0, 0, 0, 1, 2, 2}, //column 12
				{2, 2, 1, 0, 0, a[5], 0, 0, 1, 2, 2}, //column 13
				{2, 2, 1, 0, 0, 0, 0, 0, 1, 2, 2}, //column 14
		};
		
		return gameMatrix;
	}
	
	public static Coordinates[] bowlingCoordinates(int numberOfPlayers)
	{
		//First player
		Coordinates coord1 = new Coordinates(0, 5);
		Coordinates[] array = new Coordinates[6];
		array[0] = coord1;
		//Second player
		Coordinates coord2 = new Coordinates(9, 3);
		array[1] = coord2;
		//Third player
		Coordinates coord3 = new Coordinates(9, 7);
		array[2] = coord3;
		//Fourth player
		Coordinates coord4 = new Coordinates(11, 3);
		array[3] = coord4;
		//Fifth player
		Coordinates coord5 = new Coordinates(11, 7);
		array[4] = coord5;
		//Sixth player
		Coordinates coord6 = new Coordinates(13, 5);
		array[5] = coord6;
		
		return array;	
	}
	
	public static int getBombermanCell(int playerNumber)
	{
		switch (playerNumber)
		{
			case 0: return PLAYER1;
			case 1: return PLAYER2;
			case 2: return PLAYER3;
			case 3: return PLAYER4;
			case 4: return PLAYER5;
			case 5: return PLAYER6;
			default: return FREE_CELL;
		}
	}
	
	public static int getBombCell(int playerNumber)
	{
		switch (playerNumber)
		{
			case 0: return BOMB_PLAYER1;
			case 1: return BOMB_PLAYER2;
			case 2: return BOMB_PLAYER3;
			case 3: return BOMB_PLAYER4;
			case 4: return BOMB_PLAYER5;
			case 5: return BOMB_PLAYER6;
			default: return FREE_CELL;
		}
	}
	
	public static int[] getExplosionArray(int playerNumber)
	{
		switch (playerNumber)
		{
			case 0: return PLAYER1_EXPLOSIONS;
			case 1: return PLAYER2_EXPLOSIONS;
			case 2: return PLAYER3_EXPLOSIONS;
			case 3: return PLAYER4_EXPLOSIONS;
			case 4: return PLAYER5_EXPLOSIONS;
			case 5: return PLAYER6_EXPLOSIONS;
			//This case can in theory never happen
			default: return PLAYER1_EXPLOSIONS;
		}
	}
	public static int getMin(int playerNumber)
	{
		switch (playerNumber)
		{
			case 0: return EXPLOSION_CENTER_PLAYER1;
			case 1: return EXPLOSION_CENTER_PLAYER2;
			case 2: return EXPLOSION_CENTER_PLAYER3;
			case 3: return EXPLOSION_CENTER_PLAYER4;
			case 4: return EXPLOSION_CENTER_PLAYER5;
			case 5: return EXPLOSION_CENTER_PLAYER6;
			//This case can in theory never happen
			default: return EXPLOSION_CENTER_PLAYER1;
		}
	}
	public static int getMax(int playerNumber)
	{
		switch (playerNumber)
		{
			case 0: return EXPLOSION_TERMINAL_LEFT_PLAYER1;
			case 1: return EXPLOSION_TERMINAL_LEFT_PLAYER2;
			case 2: return EXPLOSION_TERMINAL_LEFT_PLAYER3;
			case 3: return EXPLOSION_TERMINAL_LEFT_PLAYER4;
			case 4: return EXPLOSION_TERMINAL_LEFT_PLAYER5;
			case 5: return EXPLOSION_TERMINAL_LEFT_PLAYER6;
			//This case can in theory never happen
			default: return EXPLOSION_TERMINAL_LEFT_PLAYER1;
		}
	}
	
	public static int getPlayerAndBomb(int playerNumber)
	{
		switch (playerNumber)
		{
			case 0: return BOMB_AND_PLAYER1;
			case 1: return BOMB_AND_PLAYER2;
			case 2: return BOMB_AND_PLAYER3;
			case 3: return BOMB_AND_PLAYER4;
			case 4: return BOMB_AND_PLAYER5;
			case 5: return BOMB_AND_PLAYER6;
			default: return FREE_CELL;
		}
	}
}
