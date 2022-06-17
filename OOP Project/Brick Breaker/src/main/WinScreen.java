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

public class WinScreen
{
	/*
	 * 
	 * TO LOCATE THE BUTTON.
	 * 
	 */
	private Rectangle mainMenu;
	private Image background;
	
	/*
	 * 
	 * GAME WIN FUNCTION.
	 * 
	 */
	public WinScreen()
	{
		mainMenu = new Rectangle(Frame.WIDTH/2-60, 380, 150, 55);
		background = new ImageLoader(ImageLoader.titleB).getImage();
		if(Controller.level < Level.MAX_LEVEL-1)
		{
			if(Level.lockedLevels[Controller.level+1] == true)
			{
				Level.lockedLevels[Controller.level+1] = false;
				Files.SaveProgress(Level.lockedLevels);
			}
		}
	}
	public void tick() {
		if(mainMenu.contains(Controller.mousePoint) && MouseHandler.MOUSEDOWN) {
			Controller.switchStates(Controller.STATE.PICKLEVEL);
		}
	}
	
	/*
	 * 
	 * TO SHOW THE GAME WIN SCREEN AFTER GAME WINING.
	 * 
	 */
	public void render(Graphics g) {
		g.drawImage(background, 0, 0, Frame.WIDTH, Frame.HEIGHT, null);
		g.setColor(Color.BLACK);
		g.setFont(Controller.bigFont);
		/*
		 * 
		 * TO SHOW THE MASSAGE.
		 * 
		 */
		g.drawString("You Win!!", Frame.WIDTH/2-g.getFontMetrics().stringWidth("You Win!!")/2, 150);
		/*
		 * 
		 * TO SHOW THE SCORE.
		 * 
		 */
		g.drawString("Score: " + Controller.score, Frame.WIDTH/2-g.getFontMetrics().stringWidth("Score" + Controller.score)/2, 225);
		g.drawRect(mainMenu.x, mainMenu.y, mainMenu.width, mainMenu.height);
		if(mainMenu.contains(Controller.mousePoint)) {
			g.setColor(new Color(200, 200, 200, 100));
			g.fillRect(mainMenu.x, mainMenu.y, mainMenu.width, mainMenu.height);
			g.setColor(Color.black);
		}
		/*
		 * 
		 * TO DRAW THE PICK LEVEL BOTTON.
		 * 
		 */
		g.drawString("Pick Level", mainMenu.x + 15, mainMenu.y + 30);
	}
}
