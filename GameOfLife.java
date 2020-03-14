package gameOfLife;

import java.util.concurrent.TimeUnit;

/**
 * @author Sean Butler
 * 
 * This GameOfLife class is a visual automation based on the creations
 * of British mathematician John Horton Conway.
 * 
 * The game is based on cells which can either be alive or dead
 * depending on their surrounding cell neighbours which is their surrounding
 * 8 cells.
 * 
 * To run my class of GameOfLife simply call the following methods in order:
 * 1) setupGrid()
 * 2) setupInitialSeed();
 * 3) playGame();
 * 
 * For the above methods setupInitialSeed and playGame have been overloaded to allow
 * for additional functionality if the user so wishes and can be used as follows  as:
 * 
 * setupInitialSeed(4,4, 5,4, 6,4); - can have 3 sets of columns and rows provided
 * as parameters for the user to set the initial state.
 * 
 * playGame(25); - Can provide a number to set how many iterations of the GameOfLife
 * the user would like to play such as in this example being 25 iterations before stopping.
 *
 */

public class GameOfLife {
	public static int cols = 10;
	public static int rows = 10;
	public static int[][] grid = new int [cols][rows];

	public static void main(String[] args) throws InterruptedException {
		setupGrid();
		setupInitialSeed();
		//setupInitialSeed(4,4, 5,4, 6,4);
		
		//Can choose to start the game and print a grid of a single evolution or enter a number to select desired amount of iterations
		playGame();
		playGame(25);
	}
	
	/* Using a loop to setup / reset our two dimensional array to all zero values . 
     This will act as our "board" for the Game Of Life. */
	public static void setupGrid() 
	{
		for(int r = 0; r < rows; r++)
		{
			for(int c = 0; c < cols; c++)
			{
				grid[r][c] = 0;
			}
		}
	}
	
	//Setup initial seed by setting five seeds to alive
	public static void setupInitialSeed()
	{
		grid[4][4] = 1;
		grid[5][4] = 1;
		grid[6][4] = 1;
		grid[5][3] = 1;
		grid[5][5] = 1;
	}
	
	/*Overloading to allow user to select which three cells they wish to set to
	 	alive for the initial seed */
	public static void setupInitialSeed(int aRow, int aColumn, int bRow,  
										int bcolumn,  int cRow, int cColumn)
	{
		grid[aRow][aColumn] = 1;
		grid[bRow][bcolumn] = 1;
		grid[cRow][cColumn] = 1;
	}
	
	//Loop to print our "grid" (two dimensional array)
	public static void playGame() 
	{
		for(int r = 0; r < rows; r++)
		{
			for(int c = 0; c < cols; c++)
			{
				if(grid[r][c] == 0)
				{
					System.out.print("." + "\t");
				}
				else
				{
					System.out.print("*" + "\t");
				}
			}
			System.out.println("\n");
		}
	}
	
	//Overloading to allow user to select how many evolutions they wish to print
	//InterruptedException added to allow for time delay of 1 second in between each iteration display
	public static void playGame(int numberOfEvolutions) throws InterruptedException 
	{
		int stopPoint = 0;
		while(stopPoint < numberOfEvolutions)
		{
		for(int r = 0; r < rows; r++)
		{
			for(int c = 0; c < cols; c++)
			{
				if(grid[r][c] == 0)
				{
					System.out.print("." + "\t");
				}
				else
				{
					System.out.print("*" + "\t");
				}
			}
			System.out.println("\n");
		}
		//Pauses the program for 1 second to give time for user to see the changes
		TimeUnit.SECONDS.sleep(1);
		System.out.println("\n" + "\n" +"\n" +"\n");
		
		stopPoint++;
		//Calls the method that takes care of working out the next evolution
		nextEvolution();
		}
	}
	
	  //Updates grid with values for next evolution
	  public static void nextEvolution() 
	  {
		  //Temporary grid to store values of our next evolution
		  int[][] nextEvolutionGrid = new int[cols][rows];
		  

		    // Loop across each cell
		    for (int r = 1; r < cols-1; r++) 
		    {
		    	for (int c = 1; c < rows-1; c++) 
		      {
		        // Look up the neighbouring cells in a square around each cell (i.e up to 8 other cells at a time)
		    	int neighbouringCells = 0;
		        for (int nr = -1; nr <= 1; nr++)
		        {
		        	for (int nc = -1; nc <= 1; nc++) 
		        	{
		            neighbouringCells += grid[r+nr][c+nc];
		            }
		        }
		        /* Change neighbouringCells value back to its original value
		           to check how how many neighbour cells it had. */
		        neighbouringCells -= grid[r][c];

		        // Apply rules based on neighbouring cells
		        
		        // 1) Death - Loneliness
		        if((grid[r][c] == 1) && (neighbouringCells <  2))
		        	{
		        	nextEvolutionGrid[r][c] = 0;           
		        	}
		        // 2) Death - Over Population
		        else if ((grid[r][c] == 1) && (neighbouringCells >  3))
		        	{
		        	nextEvolutionGrid[r][c] = 0;           
		        	}
		        // 3) Life - Reproduction
		        else if ((grid[r][c] == 0) && (neighbouringCells == 3))
		        	{
		        	nextEvolutionGrid[r][c] = 1;           
		        	}
		        // 4) Stasis - No Change
		        else
		        	{
		        	nextEvolutionGrid[r][c] = grid[r][c];  
		        	}
		      }
		    }
		    
		    // Update our grid to show the updated values to move on to the next evolution
		    grid = nextEvolutionGrid;
		  }
}
