package com.example.bomberman;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Menu;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;

public class GameActivity extends Activity {

	//SurfaceView and related variables
	SurfaceView surface;
	SurfaceHolder holder1;
	Canvas canvas;
	Paint paint;
	
	//SurfaceView Matrix variables
	int[][] givenMatrix = new int[11][15];
	int width, height, cellWidth, cellHeight;
	
	//The bitmaps for the bricks
	Bitmap brick, destructibleBrick, freeCell, blackBomberman, blackBomb, redBomberman, redBomb;
	Bitmap player1ExplosionCenter, player1ExplosionMiddleUp, player1ExplosionMiddleDown, player1ExplosionMiddleLeft, player1ExplosionMiddleRight, player1ExplosionTerminalUp, player1ExplosionTerminalDown, player1ExplosionTerminalRight, player1ExplosionTerminalLeft;
	Bitmap player2ExplosionCenter, player2ExplosionMiddleUp, player2ExplosionMiddleDown, player2ExplosionMiddleLeft, player2ExplosionMiddleRight, player2ExplosionTerminalUp, player2ExplosionTerminalDown, player2ExplosionTerminalRight, player2ExplosionTerminalLeft;
	
	
	CountDownTimer count;
	
	//The Game itself
	Game newGame;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		
		newGame = new Game(2, GameMatrix.bowlingScheme(2));
		
		givenMatrix = newGame.getGameMatrix();
		
		//The surface of the game matrix
		surface = (SurfaceView) findViewById(R.id.surfaceView1);
		surface.setZOrderOnTop(true);
		
		holder1 = surface.getHolder();	
		holder1.setFormat(PixelFormat.TRANSPARENT);
		holder1.addCallback(new Callback() {
			
			public void surfaceDestroyed(SurfaceHolder holder) {
				// TODO Auto-generated method stub
				
			}
			
			public void surfaceCreated(SurfaceHolder holder) {
				
				//canvas = holder1.lockCanvas();
				
				
				width = surface.getWidth();
				height = surface.getHeight();
				
				cellWidth = width / 15;
				cellHeight = height / 11;
				
				loadImages();
				
				updateMatrix(givenMatrix);
				count.start();
				//holder1.unlockCanvasAndPost(canvas);								
			}
			
			public void surfaceChanged(SurfaceHolder holder, int format, int width,
					int height) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		count = new CountDownTimer(36000000,100) {
			
			@Override
			public void onTick(long millisUntilFinished) {
								
				
				width = surface.getWidth();
				height = surface.getHeight();
				
				cellWidth = width / 15;
				cellHeight = height / 11;
				
				newGame.updateBombermans();
				newGame.updateBombs();
				newGame.updateExplosions();
				//if (millisUntilFinished % 50 == 0)
					newGame.moveArtificialBomberman();
				updateMatrix(newGame.getGameMatrix());
							
			}
			
			@Override
			public void onFinish() {
				// TODO Auto-generated method stub
				
			}
		};
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}
	
	//Movement methods
	public void moveLeft(View v)
	{
		newGame.moveLeft(0);
		newGame.updateBombermans();
		//updateMatrix(newGame.getGameMatrix());
		Log.println (Log.DEBUG, "exemplu log", "moveLeft - Activity");
	}
	public void moveRight(View v)
	{
		newGame.moveRight(0);
		newGame.updateBombermans();
		//updateMatrix(newGame.getGameMatrix());
		Log.println (Log.DEBUG, "exemplu log", "moveRight - Activity");
	}
	public void moveUp(View v)
	{
		newGame.moveUp(0);
		newGame.updateBombermans();
		//updateMatrix(newGame.getGameMatrix());
		Log.println (Log.DEBUG, "exemplu log", "moveUp - Activity");
	}
	public void moveDown(View v)
	{
		newGame.moveDown(0);
		newGame.updateBombermans();
		//updateMatrix(newGame.getGameMatrix());
		Log.println (Log.DEBUG, "exemplu log", "moveDown - Activity");
	}
	public void placeBomb(View v)
	{
		System.out.println("bombPlaced");
		newGame.placeBomb(0);
	}
	
	public void loadImages()
	{
		//Image options => scale purpose
		BitmapFactory.Options option = new BitmapFactory.Options();
		option.inSampleSize = 1;
		
		//Load the non-destructible brick
		Drawable blankDrawable = GameActivity.this.getResources().getDrawable(R.drawable.unbreakbrick);
		brick = ((BitmapDrawable)blankDrawable).getBitmap();
		brick = BitmapFactory.decodeResource(getResources(), R.drawable.unbreakbrick, option);
		brick = Bitmap.createScaledBitmap(brick, cellWidth, cellHeight, true);
		
		//Load the destructible brick
		blankDrawable = GameActivity.this.getResources().getDrawable(R.drawable.breakbrick);
		destructibleBrick = ((BitmapDrawable)blankDrawable).getBitmap();
		destructibleBrick = BitmapFactory.decodeResource(getResources(), R.drawable.breakbrick, option);
		destructibleBrick = Bitmap.createScaledBitmap(destructibleBrick, cellWidth, cellHeight, true);
		
		//Load the free cell
		blankDrawable = GameActivity.this.getResources().getDrawable(R.drawable.freecell);
		freeCell = ((BitmapDrawable)blankDrawable).getBitmap();
		freeCell = BitmapFactory.decodeResource(getResources(), R.drawable.freecell, option);
		freeCell = Bitmap.createScaledBitmap(freeCell, cellWidth, cellHeight, true);
				
		//Load bomberman
		blankDrawable = GameActivity.this.getResources().getDrawable(R.drawable.blackbomberman);
		blackBomberman = ((BitmapDrawable)blankDrawable).getBitmap();
		blackBomberman = BitmapFactory.decodeResource(getResources(), R.drawable.blackbomberman, option);
		blackBomberman = Bitmap.createScaledBitmap(blackBomberman, cellWidth, cellHeight, true);
		
		blankDrawable = GameActivity.this.getResources().getDrawable(R.drawable.redbomberman);
		redBomberman = ((BitmapDrawable)blankDrawable).getBitmap();
		redBomberman = BitmapFactory.decodeResource(getResources(), R.drawable.redbomberman, option);
		redBomberman = Bitmap.createScaledBitmap(redBomberman, cellWidth, cellHeight, true);
		
		
		//Load bombs
		blankDrawable = GameActivity.this.getResources().getDrawable(R.drawable.blackbomb);
		blackBomb = ((BitmapDrawable)blankDrawable).getBitmap();
		blackBomb = BitmapFactory.decodeResource(getResources(), R.drawable.blackbomb, option);
		blackBomb = Bitmap.createScaledBitmap(blackBomb, cellWidth, cellHeight, true);
		
		blankDrawable = GameActivity.this.getResources().getDrawable(R.drawable.redbomb);
		redBomb = ((BitmapDrawable)blankDrawable).getBitmap();
		redBomb = BitmapFactory.decodeResource(getResources(), R.drawable.redbomb, option);
		redBomb = Bitmap.createScaledBitmap(redBomb, cellWidth, cellHeight, true);
		
		
		
		//Load Explosion player1
		
		//Epicentre 
		blankDrawable = GameActivity.this.getResources().getDrawable(R.drawable.player1center);
		player1ExplosionCenter = ((BitmapDrawable)blankDrawable).getBitmap();
		player1ExplosionCenter = BitmapFactory.decodeResource(getResources(), R.drawable.player1center, option);
		player1ExplosionCenter = Bitmap.createScaledBitmap(player1ExplosionCenter, cellWidth, cellHeight, true);
		
		//Middle up
		blankDrawable = GameActivity.this.getResources().getDrawable(R.drawable.player1middleup);
		player1ExplosionMiddleUp = ((BitmapDrawable)blankDrawable).getBitmap();
		player1ExplosionMiddleUp = BitmapFactory.decodeResource(getResources(), R.drawable.player1middleup, option);
		player1ExplosionMiddleUp = Bitmap.createScaledBitmap(player1ExplosionMiddleUp, cellWidth, cellHeight, true);
		
		//Middle left
		blankDrawable = GameActivity.this.getResources().getDrawable(R.drawable.player1middleleft);
		player1ExplosionMiddleLeft = ((BitmapDrawable)blankDrawable).getBitmap();
		player1ExplosionMiddleLeft = BitmapFactory.decodeResource(getResources(), R.drawable.player1middleleft, option);
		player1ExplosionMiddleLeft = Bitmap.createScaledBitmap(player1ExplosionMiddleLeft, cellWidth, cellHeight, true);
		
		//Middle down
		blankDrawable = GameActivity.this.getResources().getDrawable(R.drawable.player1middledown);
		player1ExplosionMiddleDown = ((BitmapDrawable)blankDrawable).getBitmap();
		player1ExplosionMiddleDown = BitmapFactory.decodeResource(getResources(), R.drawable.player1middledown, option);
		player1ExplosionMiddleDown = Bitmap.createScaledBitmap(player1ExplosionMiddleDown, cellWidth, cellHeight, true);
		
		//Middle right
		blankDrawable = GameActivity.this.getResources().getDrawable(R.drawable.player1middleright);
		player1ExplosionMiddleRight = ((BitmapDrawable)blankDrawable).getBitmap();
		player1ExplosionMiddleRight = BitmapFactory.decodeResource(getResources(), R.drawable.player1middleright, option);
		player1ExplosionMiddleRight = Bitmap.createScaledBitmap(player1ExplosionMiddleRight, cellWidth, cellHeight, true);
		
		//Terminal up
		blankDrawable = GameActivity.this.getResources().getDrawable(R.drawable.player1endup);
		player1ExplosionTerminalUp = ((BitmapDrawable)blankDrawable).getBitmap();
		player1ExplosionTerminalUp = BitmapFactory.decodeResource(getResources(), R.drawable.player1endup, option);
		player1ExplosionTerminalUp = Bitmap.createScaledBitmap(player1ExplosionTerminalUp, cellWidth, cellHeight, true);
		
		//Terminal left
		blankDrawable = GameActivity.this.getResources().getDrawable(R.drawable.player1endleft);
		player1ExplosionTerminalLeft = ((BitmapDrawable)blankDrawable).getBitmap();
		player1ExplosionTerminalLeft = BitmapFactory.decodeResource(getResources(), R.drawable.player1endleft, option);
		player1ExplosionTerminalLeft = Bitmap.createScaledBitmap(player1ExplosionTerminalLeft, cellWidth, cellHeight, true);
		
		//Terminal down
		blankDrawable = GameActivity.this.getResources().getDrawable(R.drawable.player1enddown);
		player1ExplosionTerminalDown = ((BitmapDrawable)blankDrawable).getBitmap();
		player1ExplosionTerminalDown = BitmapFactory.decodeResource(getResources(), R.drawable.player1enddown, option);
		player1ExplosionTerminalDown = Bitmap.createScaledBitmap(player1ExplosionTerminalDown, cellWidth, cellHeight, true);
		
		//Terminal right
		blankDrawable = GameActivity.this.getResources().getDrawable(R.drawable.player1endright);
		player1ExplosionTerminalRight = ((BitmapDrawable)blankDrawable).getBitmap();
		player1ExplosionTerminalRight = BitmapFactory.decodeResource(getResources(), R.drawable.player1endright, option);
		player1ExplosionTerminalRight = Bitmap.createScaledBitmap(player1ExplosionTerminalRight, cellWidth, cellHeight, true);
		
		
		//Load Explosion player2
		
		//Epicentre 
		blankDrawable = GameActivity.this.getResources().getDrawable(R.drawable.player2center);
		player2ExplosionCenter = ((BitmapDrawable)blankDrawable).getBitmap();
		player2ExplosionCenter = BitmapFactory.decodeResource(getResources(), R.drawable.player2center, option);
		player2ExplosionCenter = Bitmap.createScaledBitmap(player2ExplosionCenter, cellWidth, cellHeight, true);
				
		//Middle up
		blankDrawable = GameActivity.this.getResources().getDrawable(R.drawable.player2middleup);
		player2ExplosionMiddleUp = ((BitmapDrawable)blankDrawable).getBitmap();
		player2ExplosionMiddleUp = BitmapFactory.decodeResource(getResources(), R.drawable.player2middleup, option);
		player2ExplosionMiddleUp = Bitmap.createScaledBitmap(player2ExplosionMiddleUp, cellWidth, cellHeight, true);
				
		//Middle left
		blankDrawable = GameActivity.this.getResources().getDrawable(R.drawable.player2middleleft);
		player2ExplosionMiddleLeft = ((BitmapDrawable)blankDrawable).getBitmap();
		player2ExplosionMiddleLeft = BitmapFactory.decodeResource(getResources(), R.drawable.player2middleleft, option);
		player2ExplosionMiddleLeft = Bitmap.createScaledBitmap(player2ExplosionMiddleLeft, cellWidth, cellHeight, true);
				
		//Middle down
		blankDrawable = GameActivity.this.getResources().getDrawable(R.drawable.player2middledown);
		player2ExplosionMiddleDown = ((BitmapDrawable)blankDrawable).getBitmap();
		player2ExplosionMiddleDown = BitmapFactory.decodeResource(getResources(), R.drawable.player2middledown, option);
		player2ExplosionMiddleDown = Bitmap.createScaledBitmap(player2ExplosionMiddleDown, cellWidth, cellHeight, true);
				
		//Middle right
		blankDrawable = GameActivity.this.getResources().getDrawable(R.drawable.player2middleright);
		player2ExplosionMiddleRight = ((BitmapDrawable)blankDrawable).getBitmap();
		player2ExplosionMiddleRight = BitmapFactory.decodeResource(getResources(), R.drawable.player2middleright, option);
		player2ExplosionMiddleRight = Bitmap.createScaledBitmap(player2ExplosionMiddleRight, cellWidth, cellHeight, true);
				
		//Terminal up
		blankDrawable = GameActivity.this.getResources().getDrawable(R.drawable.player2endup);
		player2ExplosionTerminalUp = ((BitmapDrawable)blankDrawable).getBitmap();
		player2ExplosionTerminalUp = BitmapFactory.decodeResource(getResources(), R.drawable.player2endup, option);
		player2ExplosionTerminalUp = Bitmap.createScaledBitmap(player2ExplosionTerminalUp, cellWidth, cellHeight, true);
				
		//Terminal left
		blankDrawable = GameActivity.this.getResources().getDrawable(R.drawable.player2endleft);
		player2ExplosionTerminalLeft = ((BitmapDrawable)blankDrawable).getBitmap();
		player2ExplosionTerminalLeft = BitmapFactory.decodeResource(getResources(), R.drawable.player2endleft, option);
		player2ExplosionTerminalLeft = Bitmap.createScaledBitmap(player2ExplosionTerminalLeft, cellWidth, cellHeight, true);
				
		//Terminal down
		blankDrawable = GameActivity.this.getResources().getDrawable(R.drawable.player2enddown);
		player2ExplosionTerminalDown = ((BitmapDrawable)blankDrawable).getBitmap();
		player2ExplosionTerminalDown = BitmapFactory.decodeResource(getResources(), R.drawable.player2enddown, option);
		player2ExplosionTerminalDown = Bitmap.createScaledBitmap(player2ExplosionTerminalDown, cellWidth, cellHeight, true);
				
		//Terminal right
		blankDrawable = GameActivity.this.getResources().getDrawable(R.drawable.player2endright);
		player2ExplosionTerminalRight = ((BitmapDrawable)blankDrawable).getBitmap();
		player2ExplosionTerminalRight = BitmapFactory.decodeResource(getResources(), R.drawable.player2endright, option);
		player2ExplosionTerminalRight = Bitmap.createScaledBitmap(player2ExplosionTerminalRight, cellWidth, cellHeight, true);
				
			
	}
	
	public void updateMatrix(int [][] matrix)
	{
		canvas = holder1.lockCanvas();
		//System.out.println(cellWidth + " " + cellHeight);
		//System.out.println(blackBomberman + " " + canvas);
		//System.out.println();
		for (int i = 0; i < 15; i ++)
		{
			for (int j = 0; j < 11; j ++)
			{
				//Creation of the wall and inner non-destructible bricks
				if (matrix[i][j] == GameMatrix.FREE_CELL)
					canvas.drawBitmap(freeCell, i * cellWidth, j * cellHeight, null);
				else if (matrix[i][j] == GameMatrix.BRICK)
					canvas.drawBitmap(brick, i * cellWidth, j * cellHeight, null);
				//Creation of the destructible bricks
				else if (matrix[i][j] == GameMatrix.DESTRUCTIBLE_BRICK)
					canvas.drawBitmap(destructibleBrick, i * cellWidth, j * cellHeight, null);
				
				//Player1
				else if (matrix[i][j] == GameMatrix.PLAYER1 && newGame.getBomberman(0).getStatus())
					canvas.drawBitmap(blackBomberman, i * cellWidth, j * cellHeight, null);
				//Player1 bomb
				else if (matrix[i][j] == GameMatrix.BOMB_PLAYER1)
					canvas.drawBitmap(blackBomb, i * cellWidth, j * cellHeight, null);
				//Player1 explosions
				else if (matrix[i][j] == GameMatrix.EXPLOSION_CENTER_PLAYER1)
					canvas.drawBitmap(player1ExplosionCenter, i * cellWidth, j * cellHeight, null);
				else if (matrix[i][j] == GameMatrix.EXPLOSION_MIDDLE_UP_PLAYER1)
					canvas.drawBitmap(player1ExplosionMiddleUp, i * cellWidth, j * cellHeight, null);
				else if (matrix[i][j] == GameMatrix.EXPLOSION_MIDDLE_LEFT_PLAYER1)
					canvas.drawBitmap(player1ExplosionMiddleLeft, i * cellWidth, j * cellHeight, null);
				else if (matrix[i][j] == GameMatrix.EXPLOSION_MIDDLE_DOWN_PLAYER1)
					canvas.drawBitmap(player1ExplosionMiddleDown, i * cellWidth, j * cellHeight, null);
				else if (matrix[i][j] == GameMatrix.EXPLOSION_MIDDLE_RIGHT_PLAYER1)
					canvas.drawBitmap(player1ExplosionMiddleRight, i * cellWidth, j * cellHeight, null);
				else if (matrix[i][j] == GameMatrix.EXPLOSION_TERMINAL_UP_PLAYER1)
					canvas.drawBitmap(player1ExplosionTerminalUp, i * cellWidth, j * cellHeight, null);
				else if (matrix[i][j] == GameMatrix.EXPLOSION_TERMINAL_LEFT_PLAYER1)
					canvas.drawBitmap(player1ExplosionTerminalLeft, i * cellWidth, j * cellHeight, null);
				else if (matrix[i][j] == GameMatrix.EXPLOSION_TERMINAL_DOWN_PLAYER1)
					canvas.drawBitmap(player1ExplosionTerminalDown, i * cellWidth, j * cellHeight, null);
				else if (matrix[i][j] == GameMatrix.EXPLOSION_TERMINAL_RIGHT_PLAYER1)
					canvas.drawBitmap(player1ExplosionTerminalRight, i * cellWidth, j * cellHeight, null);
				
				//Player2
				else if (matrix[i][j] == GameMatrix.PLAYER2 && newGame.getBomberman(0).getStatus())
					canvas.drawBitmap(redBomberman, i * cellWidth, j * cellHeight, null);
				//Player2 bomb
				else if (matrix[i][j] == GameMatrix.BOMB_PLAYER2)
					canvas.drawBitmap(redBomb, i * cellWidth, j * cellHeight, null);
				//Player2explosions
				else if (matrix[i][j] == GameMatrix.EXPLOSION_CENTER_PLAYER2)
					canvas.drawBitmap(player2ExplosionCenter, i * cellWidth, j * cellHeight, null);
				else if (matrix[i][j] == GameMatrix.EXPLOSION_MIDDLE_UP_PLAYER2)
					canvas.drawBitmap(player2ExplosionMiddleUp, i * cellWidth, j * cellHeight, null);
				else if (matrix[i][j] == GameMatrix.EXPLOSION_MIDDLE_LEFT_PLAYER2)
					canvas.drawBitmap(player2ExplosionMiddleLeft, i * cellWidth, j * cellHeight, null);
				else if (matrix[i][j] == GameMatrix.EXPLOSION_MIDDLE_DOWN_PLAYER2)
					canvas.drawBitmap(player2ExplosionMiddleDown, i * cellWidth, j * cellHeight, null);
				else if (matrix[i][j] == GameMatrix.EXPLOSION_MIDDLE_RIGHT_PLAYER2)
					canvas.drawBitmap(player2ExplosionMiddleRight, i * cellWidth, j * cellHeight, null);
				else if (matrix[i][j] == GameMatrix.EXPLOSION_TERMINAL_UP_PLAYER2)
					canvas.drawBitmap(player2ExplosionTerminalUp, i * cellWidth, j * cellHeight, null);
				else if (matrix[i][j] == GameMatrix.EXPLOSION_TERMINAL_LEFT_PLAYER2)
					canvas.drawBitmap(player2ExplosionTerminalLeft, i * cellWidth, j * cellHeight, null);
				else if (matrix[i][j] == GameMatrix.EXPLOSION_TERMINAL_DOWN_PLAYER2)
					canvas.drawBitmap(player2ExplosionTerminalDown, i * cellWidth, j * cellHeight, null);
				else if (matrix[i][j] == GameMatrix.EXPLOSION_TERMINAL_RIGHT_PLAYER2)
					canvas.drawBitmap(player2ExplosionTerminalRight, i * cellWidth, j * cellHeight, null);
				
				}//for
			}//for
		holder1.unlockCanvasAndPost(canvas);	
	}
	
	public void onDestroy()
	{
		super.onDestroy();
		finish();
	}
}
