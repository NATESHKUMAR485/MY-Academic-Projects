package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import files.Files;
import files.Level;
import handlers.KeyHandler;
import parts.Ball;
import parts.Brick;
import parts.Paddle;
import parts.Powerup;

public class Board extends JPanel
{
	/*
	 * 
	 * DECLEARATION OF VARIABLES.
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Paddle PDL;
	private Ball[] BALL;
	private Brick[] TILES;
	private Image lives;
	private Powerup[] powerups;
	private int[][] gridPos = new int[8][10];
 	private int score = 0;
 	private boolean GStarted = false;
 	private boolean debug = false;
 	private int livesLeft = 2;
 	private int NOofBALLS = 1;
 	private int ALLBRICKS = 0;
 	private int level;
 	
 	
 	/*
 	 * 
 	 * SELECT LEVEL.
 	 * 
 	 */
	public Board(int level)
	{
		PDL = new Paddle(Frame.WIDTH/2-50, 400);
		BALL = new Ball[3];
		BALL[0] = new Ball(PDL.getX()+PDL.width/2-12, PDL.getY()-PDL.height/2-10, false);
		NOofBALLS = 1;
		this.level = level;
		gridPos = Level.getLevel(level);
		
		for(int i = 0; i < gridPos.length; i++)
		{
			for(int j = 0; j < gridPos[0].length; j++)
			{
				if(gridPos[i][j] != 0)
				{
					ALLBRICKS++;
				}
			}
		}
		
		
		init();
	}
	
	public void init()
	{
		int count = 0;
		lives = new ImageLoader(ImageLoader.BallImg).getImage();
		TILES = new Brick[80];//60 is max
		powerups = new Powerup[5];
		for(int i = 0; i < gridPos.length; i++)
		{
			for(int j = 0; j < gridPos[0].length; j++)
			{
				TILES[count] = new Brick(j*50, i*25, gridPos[i][j]);
				count++;
			}
		}
	}
	
	/*
	 * 
	 * GMAE START
	 * 
	 */
	public void tick()
	{
		if(GStarted)
		{
			for(int i = 0; i < BALL.length; i++)
			{
				if(BALL[i] != null)
				{
					BALL[i].tick();
					BALL[i].checkBrickCollision(TILES);
					BALL[i].checkPaddleCollision(PDL);
					if(BALL[i].getY() > Frame.HEIGHT-50)
					{
						if(NOofBALLS <= 1)
						{
						GStarted = false;
						BALL[i] = new Ball(PDL.getX()+PDL.width/2-12, PDL.getY()-PDL.height/2-10, false);
						livesLeft -= 1;
							if(livesLeft < 0)
							{ 
								/*
								 * 
								 * SHOW GAME OVER SCREEN.
								 * 
								 */
								Controller.score = score;
								Controller.switchStates(Controller.STATE.GAMEOVER);
							}
						}else {
							BALL[i] = null;
							NOofBALLS--;
						}
					}
				}
			}
			for(int i = 0; i < TILES.length; i++) {
				if(TILES[i].hasDied) {
					ALLBRICKS--;
					score += TILES[i].originalLevel;
					if(ALLBRICKS == 0) {
						/*
						 * 
						 * SHOW WINNING SCREEN.
						 * 
						 */
						Controller.score = score;
						Controller.switchStates(Controller.STATE.WINSCREEN);
					}
					TILES[i].hasDied = false;
				}
				if(TILES[i].dropPowerup) {
					for(int j = 0; j < powerups.length; j++) {
						if(powerups[j] == null) {
							powerups[j] = new Powerup(TILES[i].getX(), TILES[i].getY(), TILES[i].hasPowerup());
							TILES[i].dropPowerup = false;
							break;
						}
					}
				}
				TILES[i].dropPowerup = false;
			}
			
			/*
			 * 
			 * USE POWERUPS.
			 * 
			 */
			for(int i = 0; i < powerups.length; i++)
			{
				if(powerups[i] != null)
				{
					powerups[i].tick();
					if(powerups[i].remove)
					{
						powerups[i] = null;
					}
					if(PDL.isColliding(powerups[i]))
					{	
						if(powerups[i].powerup == 1)
						{
							/*
							 * 
							 * TO ADD ANOTHER BALL.
							 * 
							 */
							for(int j = 0; j < BALL.length; j++)
							{
								if(BALL[j] == null)
								{
									BALL[j] = new Ball(Frame.WIDTH/2, 350, false);
									NOofBALLS ++;
									break;
								}
							}
						}
						if(powerups[i].powerup == 2)
						{
							/*
							 * 
							 * TO GROW UP PADDLE.
							 * 
							 */
							PDL.width += 15;
						}
						if(powerups[i].powerup == 3)
						{
							/*
							 * 
							 * TO LOAD FIRE BALL.
							 * 
							 */
							for(int j = 0; j < BALL.length; j++)
							{
								if(BALL[j] != null)
								{
									BALL[j].setOnFire(4);
									break;
								}
							}
						}
						powerups[i] = null;
					}
				}
			}
		}
		else if(!GStarted)
		{
			for(int i = 0; i < BALL.length; i++)
			{
				if(BALL[i] != null)
				{
					BALL[i].setX(PDL.getX()+PDL.width/2-BALL[i].width/2);
				}
			}
			for(int i = 0; i < powerups.length; i++)
			{
				if(powerups[i] != null)
				{
					powerups[i] = null;
				}
			}
			if(KeyHandler.UP)
			{
				GStarted = true;
			}
		}
		/*
		 * 
		 * TO DO MOVEMENT.
		 * 
		 */
		if(KeyHandler.LEFT)
		{
			PDL.moveLeft();
		}
		if(KeyHandler.RIGHT)
		{
			PDL.moveRight();
		}
	}
	
	/*
	 * 
	 * TO DISPLAY THE GAME PANEL.
	 * 
	 */
	public void render(Graphics g) 
	{
		g.setColor(Color.gray);
		g.fillRect(0, 0, 500, 500);
		int count = 0;
		for(int i = 0; i < gridPos.length; i++) 
		{
			for(int j = 0; j < gridPos[0].length; j++) 
			{
				if(gridPos[i][j] > 0) 
				{
					g.drawImage(TILES[count].getImage(), TILES[count].getX(), TILES[count].getY(), null);
				}	
				count++;
			}
		}
		for(int i = 0; i < powerups.length; i++) 
		{
			if(powerups[i] != null) 
			{
					g.drawImage(powerups[i].getImage(), powerups[i].getX(), powerups[i].getY(), powerups[i].getWidth(), powerups[i].getWidth(), null);
			}
		}
		
		g.drawImage(PDL.getImage(), PDL.getX(), PDL.getY(), PDL.getWidth(), PDL.getHeight(), null);
		for(int i = 0; i < BALL.length; i++) 
		{
			if(BALL[i] != null) 
			{
				if(!BALL[i].onFire) 
				{		
					g.drawImage(BALL[i].getImage(), BALL[i].getX(), BALL[i].getY(), null);
				}
				else
				{
					g.drawImage(BALL[i].getImage(), BALL[i].getX(), BALL[i].getY(), null);
				}
			}
		}
		
		/*
		 * 
		 * Debugging
		 * 
		 */
		g.setColor(Color.WHITE);
		if(debug) {
			for(int i = 0; i < TILES.length; i++) {
				TILES[i].render(g);
			}
		}
		/*
		 * 
		 * End debugging.
		 * 
		 */
		g.setColor(Color.black);
		g.fillRect(0, Frame.HEIGHT-70, Frame.WIDTH, 50);
		g.setColor(Color.white);
		g.setFont(Controller.smallFont);
		g.drawString("Score: " + score, 20, Frame.HEIGHT-50);
		g.drawImage(lives, 100, Frame.HEIGHT-64, 15, 15, null);
		g.drawString(": " + livesLeft, 120, Frame.HEIGHT-50);
	}
}
