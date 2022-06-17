package main;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader
{
	/*
	 * 
	 * TO LOAD THE IMAGES FROM FOLDER AND SAVE IN STRINGS.
	 * 
	 */
	private BufferedImage ImageFG;
	public static String titleF = "/BrickBreakerForeground2.png";
	public static String titleB = "/BrickBreakerBackground3.png";
	public static String PaddleImg = "/Paddle2.png";
	public static String BrickImg = "/Bricks7.png";
	public static String BallImg = "/Ball2.png";
	public static String FireBallImg = "/FireBall.png";
	public static String ArrowImg = "/Arrow.png";
	public static String PUMultiBallImg = "/PUMulitBall.png";
	public static String PUGrowthImg = "/PUGrowth.png";
	public static String PUFireballImg = "/PUFireball.png";	
	
	/*
	 * 
	 * TO SET THE PATH.
	 * 
	 */
	public ImageLoader(String path)
	{
		try{ImageFG = ImageIO.read(ImageLoader.class.getResourceAsStream(path));}
		catch (IOException e){e.printStackTrace();}
	}
	
	/*
	 * 
	 * TO RETURN THE IMAGES.
	 * 
	 */
	public BufferedImage getImage(){return ImageFG;}
	public BufferedImage getSubImage(int section){return ImageFG.getSubimage(0, section*25, 50, 25);}
}
