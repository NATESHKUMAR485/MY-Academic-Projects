package parts;

import java.awt.Image;
import java.awt.Rectangle;

import main.Frame;
import main.ImageLoader;

public class Powerup
{
	/*
	 * 
	 * DECLARATION.
	 * 
	 */
	public int powerup;
	public Rectangle bounds;
	private int x, y;
	private int width = 25;
	private int height = 25;
	public boolean remove = false;
	private int speed = 2;
	private Image image;
	
	/*
	 * 
	 * TO SET POWERUPS AND THEIR IMAGES FOR THE GAME.
	 * 
	 */
	public Powerup(int x, int y, int type) {
		powerup = type;
		this.x = x;
		this.y = y;
		bounds = new Rectangle(x, y, width, height);
		if(powerup == 1) {
			image = new ImageLoader(ImageLoader.PUMultiBallImg).getImage();
		}
		if(powerup == 2) {
			image = new ImageLoader(ImageLoader.PUGrowthImg).getImage();
		}
		if(powerup == 3) {
			image = new ImageLoader(ImageLoader.PUFireballImg).getImage();
		}
	}
	
	/*
	 * 
	 * TO SET THE COLLISION AND REMOVING FUNCTION.
	 * 
	 */
	public void tick() {
		if(y < Frame.HEIGHT) {
			y += speed;
			bounds = new Rectangle(x, y, width, height);
		}else {
			remove = true;
		}
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	public Image getImage() {
		return image;
	}
}
