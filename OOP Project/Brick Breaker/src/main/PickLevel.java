package main;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import files.Files;
import files.Level;
import handlers.MouseHandler;

public class PickLevel
{
	/*
	 * 
	 * DECLARATION.
	 * 
	 */
	private Image arrow;
	private int page = 1;
	Rectangle[] levels = {new Rectangle(50, 200, 75, 75), new Rectangle(150, 200, 75, 75),
						  new Rectangle(250, 200, 75, 75), new Rectangle(350, 200, 75, 75)};
	Rectangle[] arrows = {new Rectangle(5, Frame.HEIGHT-90, 50, 50)};
	
	/*
	 * 
	 * TO LOAD IMAGE FOR THE BACK BUTTON.
	 * 
	 */
	public PickLevel(){arrow = new ImageLoader(ImageLoader.ArrowImg).getImage();}
	
	
	/*
	 * 
	 * ACTION TO PICK THE LEVEL FROM THE LIST.
	 * 
	 */
	public void tick()
	{
		if(MouseHandler.MOUSEDOWN)
		{
			for(int i = 0; i < levels.length; i++)
			{
				if(levels[i].contains(Controller.mousePoint))
				{
					Controller.switchStates(Controller.STATE.GAME, i*page);
				}
			}
			for(int i = 0; i < arrows.length; i++)
			{
				if(arrows[i].contains(Controller.mousePoint))
				{
					if(i == 0)
					{
						if(page > 1){page--;}
						else{Controller.switchStates(Controller.STATE.MENU);}
					}
					else{if(page < 3) {page++;}}
				}
			}
		}
	}
	
	/*
	 * 
	 * TO DRAW THE LIST OF GMAE LEVELS AND COMPLETE SCREEN.
	 * 
	 */
	public void render(Graphics g)
	{
		g.setFont(Controller.bigFont);
		Graphics2D g2 = (Graphics2D)g;
	    GradientPaint blueToBlack = new GradientPaint(0, 0, Color.CYAN, 0, 600, Color.BLUE);
	    g2.setPaint(blueToBlack);
		g.fillRect(0, 0, Frame.WIDTH, Frame.HEIGHT);
		g.setColor(Color.black);
		g.drawString("Choose Level", Frame.WIDTH/2-g.getFontMetrics().stringWidth("Choose Level")/2, 80);
		g.drawString("Page " + page, Frame.WIDTH/2-g.getFontMetrics().stringWidth("Page " + page)/2, Frame.HEIGHT-40);
		for(int i = 0; i < levels.length; i++)
		{
			g.setColor(Color.black);
			g.drawString("" + (i+(8*(page-1))), levels[i].x+35, levels[i].y+45);
			if(levels[i].contains(Controller.mousePoint))
			{
				g.setColor(new Color(255, 255, 255, 150));
				g.fillRect(levels[i].x, levels[i].y, levels[i].width, levels[i].height);
			}
			
			g.drawRect(levels[i].x, levels[i].y, levels[i].width, levels[i].height);
		}
		for(int i = 0; i < arrows.length; i++)
		{
			if(arrows[i].contains(Controller.mousePoint))
			{
				g.setColor(new Color(255, 255, 255, 150));
				g.fillRect(arrows[i].x, arrows[i].y, arrows[i].width, arrows[i].height);
			}
			g.setColor(Color.black);
			g.drawRect(arrows[i].x, arrows[i].y, arrows[i].width, arrows[i].height);
			if(i == 0) {
			g.drawImage(arrow, arrows[i].x, arrows[i].y, arrows[i].width, arrows[i].height, null);
			}

		}
	}
}
