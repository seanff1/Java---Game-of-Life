# Java---Game-of-Life
Game Of Life in Java

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
