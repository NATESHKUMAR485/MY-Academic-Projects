package parts;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import main.Frame;
import main.ImageLoader;

public class Paddle
{
	/*
	 * 
	 * DECLARATION.
	 * 
	 */
	ImageLoader loader;
	public Rectangle bounds;
	public int width = 100;
	public int height = 30;
	private int x;
	private int y;
	public int moveSpeed = 10;
	
	/*
	 * 
	 * TO STE UP THE PADDLE FOR THE GAME AND IT POSITION.
	 * 
	 */
	public Paddle(int x, int y) {
		this.x = x;
		this.y = y;
		bounds = new Rectangle(x, y, width, height);
		loader = new ImageLoader(ImageLoader.PaddleImg);
	}
	
	/*
	 * 
	 * TO GET THE IMAGE OF PADDLE.
	 * 
	 */
	public Image getImage() {
		return loader.getImage();
	}
	public void setX(int pos) {
		if(pos > 0 && pos < Frame.WIDTH) {
			this.x = pos;
		}
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return this.width;
	}
	public int getHeight() {
		return this.height;
	}
	
	/*
	 * 
	 * TO SET THE ACTION IF PADDLE AFTER COLLISION WITH POWERUPS.
	 * 
	 */
	public boolean isColliding(Powerup powerup) {
		if(powerup != null) {
			if(bounds.intersects(powerup.bounds)) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * 
	 * MOVING ACTION OF PADDLE.
	 * 
	 */
	public void moveLeft() {
		if(x > 0) {
			x -= moveSpeed;
		}
		bounds = new Rectangle(x, y, width, height);
	}
	public void moveRight() {
		if(x + width < Frame.WIDTH) {
			x += moveSpeed;
		}
		bounds = new Rectangle(x, y, width, height);
	}
	
	/*
	 * 
	 * DRAW PADDLE.
	 * 
	 */
	public void render(Graphics g) {
		g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);
	}
}
