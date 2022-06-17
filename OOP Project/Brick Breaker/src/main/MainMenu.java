package main;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import handlers.MouseHandler;
import parts.Ball;
import parts.Brick;
import parts.Paddle;

public class MainMenu
{
	/*
	 * 
	 * DECLERATION.
	 * 
	 */
	private Rectangle[] bounds = {new Rectangle(70, 310, 310, 55),}; // POSITION AND SIZE OF NEW GAME BUTTON.
	private Image titleScreenForeground;
	private Image titleScreenBackground;
	
	/*
	 * 
	 * TO LOAD THE IMAGE FOR MAIN MENU.
	 * 
	 */
	public MainMenu()
	{
		titleScreenForeground = new ImageLoader(ImageLoader.titleF).getImage();
		titleScreenBackground = new ImageLoader(ImageLoader.titleB).getImage();
	}
	
	/*
	 * 
	 * TO CHOOSE THE PICK LEVEL BUTTON.
	 * 
	 */
	public void tick()
	{
		for(int i = 0; i < bounds.length; i++)
		{
			if(bounds[i].contains(Controller.mousePoint) && MouseHandler.MOUSEDOWN)
			{
				MouseHandler.MOUSEDOWN = false;
				if(i == 0)
				{
					Controller.switchStates(Controller.STATE.PICKLEVEL);
				}
				
			}
		}
	}

	/*
	 * 
	 * TO DRAW THE COMPLETE SCREEN OF MAIN MENU.
	 * 
	 */
	public void render(Graphics g)
	{
		g.drawImage(titleScreenBackground, 0, 0, Frame.WIDTH, Frame.WIDTH, null);
		g.setColor(Color.black);
		for(int i = 0; i < bounds.length; i++)
		{
			if(bounds[i].contains(Controller.mousePoint))
			{
				g.drawRect(bounds[i].x, bounds[i].y, bounds[i].width, bounds[i].height);
			}
		}
		g.drawImage(titleScreenForeground, 0, 0, Frame.WIDTH, Frame.WIDTH, null);
	}
}
