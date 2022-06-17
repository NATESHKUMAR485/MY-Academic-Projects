package main;

import javax.swing.JFrame;

public class Frame
{
	/*
	 * 
	 * TO MAKE THE FRAME FOR THE GAME.
	 * 
	 */
	private static JFrame frame;
	/*
	 * 
	 * SIZE OF THE FRAME.
	 * 
	 */
	public static int WIDTH = 464;
	public static int HEIGHT = 500;
	/*
	 * 
	 * FUNCTION USE IN THE FRAME.
	 * 
	 */
	public static void main(String[] args)
	{
		frame = new JFrame("Brick Breaker");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new Controller());
		frame.pack();	
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
}
