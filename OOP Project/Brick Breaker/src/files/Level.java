package files;

public class Level
{	
	/*
	 * 
	 * TO MAKE DIFFRENT LEVELS OF GAME AND SAVE IT.
	 * 
	 */
	public static int MAX_LEVEL = 3;
	public static int[][][] levels = new int[4][4][9];
	public static boolean[] lockedLevels = new boolean[MAX_LEVEL+1];
	public static int[][] getLevel(int level){fillLevels();return levels[level];}
	public static void fillLevels()
	{
		levels[0] = level0;
		levels[1] = level1;
		levels[2] = level2;
		levels[3] = level3;
	}
	private static int[][] level0 =    {{3, 0, 3, 0, 2, 0, 3, 0, 3, 0},
										{1, 1, 1, 3, 0, 3, 1, 1, 1, 0},
										{2, 0, 2, 0, 3, 0, 2, 0, 2, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
	
	private static int[][] level1 =    {{0, 3, 4, 3, 0, 3, 4, 3, 0, 0},
										{2, 4, 2, 0, 2, 0, 2, 4, 2, 0},
										{4, 0, 3, 1, 3, 1, 3, 0, 4, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
	
	private static int[][] level2 =    {{2, 3, 4, 1, 5, 1, 4, 3, 2, 0},
										{4, 4, 2, 1, 2, 4, 4, 3, 3, 0},
										{1, 2, 1, 1, 3, 3, 1, 1, 2, 0},
										{4, 3, 2, 1, 5, 1, 2, 3, 4, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
	
	private static int[][] level3 =    {{6, 5, 4, 3, 2, 3, 4, 5, 6, 0},
										{2, 3, 4, 5, 6, 5, 4, 3, 2, 0},
										{4, 2, 4, 0, 5, 0, 4, 2, 4, 0},
										{0, 6, 0, 0, 7, 0, 0, 6, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

}
