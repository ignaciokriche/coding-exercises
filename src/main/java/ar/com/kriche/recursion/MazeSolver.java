package ar.com.kriche.recursion;


/**
 *
 * Solves a maze. Just for demo!
 * 
 * @author kriche
 *
 */
public class MazeSolver {
    
    // These 3 can have the same value, if wanted:
    private static final char START = 'S';
    private static final char CURRENT_POSITION = 'C';
    private static final char CURRENT_PATH = '#';
    private static final char PATH = ' ';
    private static final char WALL = 'X';
    private static final char BREADCRUMB = '*';
    private static final char FINISH = 'F';

    private static final int INI_X= 26;
    private static final int INI_Y= 41;
    
    private static long DELAY= 150;

    public static void main(String args[]) {
        
        char[][] theMaze= generateMaze();

        boolean solutionFound= findPath(theMaze, INI_X, INI_Y);

        // After we are done, just remove the breadcrumbs and mark the starting point with a
        // different symbol to show where all began.
        removeBreadCrumbs(theMaze);
        theMaze[INI_X][INI_Y]= START;
        printMaze(theMaze);

        if (!solutionFound) {
            System.out.println("Oops, this maze has no solution.");
        }

    }

    /**
     * Prints the first solution it finds into the maze.
     * @param maze
     * @param x
     * @param y
     * @return true only if a solution was found.
     */
    private static boolean findPath(char[][] maze, int x, int y) {

        switch(maze[x][y]){

            // We have found a way out!
            case FINISH:
                return true;

            // Oops, there is a wall!
            case WALL:
            // Oops, we have been here before!
            case BREADCRUMB:
            case CURRENT_PATH:
                return false; //So this is not a way out!

            default:

                // We are inside the maze yet (PATH)!

                //Show where we are:
                maze[x][y]= CURRENT_POSITION;
                printMaze(maze);

                // And we continue in each direction possible (one at the time) to see what we find.
                // Note that as soon as we find one solution we don't explore the rest!
                // Java || operator is lazy
                maze[x][y]= CURRENT_PATH;
                boolean found= findPath(maze, x + 1, y) ||
                                findPath(maze, x - 1, y) ||
                                findPath(maze, x, y + 1) ||
                                findPath(maze, x, y - 1);
                
                if (found){
                    // we are in a solution path!
                    return true;
                }

                //Show where we are when backtracking as well:
                maze[x][y]= CURRENT_POSITION;
                printMaze(maze);

                //Restore the breadcrumb (no longer current path):
                maze[x][y]= BREADCRUMB;
                   
                // There wasn't a solution from this position so return false.
                return false;
        }

    }

    /**
     *
     * @return a maze form only by WALL, PATH, or FINISH symbols! There perimeter cannot contain PATH symbols!
     */
    private static char[][] generateMaze(){

        // TODO the maze could be randomly generated using backtracking as well!
        return new char[][] {
        "XXXXXXXXXFXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX".toCharArray(),
        "XXXXXXXXX XXXXXX         XXXXXXXXXXXX  XXXXXXXXXXXXXXXXXX                 XXXXXX      XXX".toCharArray(),
        "XXXXX            XXXXXXX XXXXXXXXXXXXX       XXXXX XXXXXX XXXXXXXXXXXXXXX        XXXX XXX".toCharArray(),
        "XXXXXXXXXXXXXXXX XXXXXXX         XXXXXXXXXXX XXXXX      X XXXXXXXXXXXXXXXXXXXXXX XXXX XXX".toCharArray(),
        "XXXXX        XXX XXXXXXXXXXXXXX XXXX       X       XXXXXX XXXXX      XXXX     XX XXXX XXX".toCharArray(),
        "XXXXX XXXXXX XXX        XXXXXXX XXXX XXXXX XXXXXXX XXXXXX XXXXX XXXX XXXX XXX XX XXXX XXX".toCharArray(),
        "XXXXX XXX XX XXXXXXXXXX        XXXXX XXXXX       X XXXXXX XXXXX XXXX XXXX XXX XX XXXX XXX".toCharArray(),
        "XXXXX XXX XX XXXXX XXXXXXXXXXX       XXXXXXX XXX X    XXX XXXXX XXXX      XXX XX XXXX XXX".toCharArray(),
        "XXXXX XXX    XXXXX  XXXXXXXXXXXXXXXXXXXXXXXX XXX XXXX XXX XXXXX XXXXXXXXXXXXX    XXXX XXX".toCharArray(),
        "XXXXX XXXX XXXXXXXXX XXX   XXXXXXXXXXXXXXXXX XXX XXXX     XXXXX XXXXXXXXXXXXXXXX XXXX XXX".toCharArray(),
        "XXXXX      XXXXXXXXX XXXXX   XXXXXXXXXXX XXX XXX XXXXXX XXXXXXX XXXXXXXXXXXXXXXX        X".toCharArray(),
        "XXXXXXX XX XXXXX        XXXX XXXXXXXXXXX XXX XXX XXXXXX XXXXXXX                  XXXXXX X".toCharArray(),
        "XXXXXXX XX XXXXX XXXXXX XXXX XXXXXXXXXXX X                   XX  X XXXXXXXXXXXXX XX   X X".toCharArray(),
        "XXX     XX XXXXX XXXXXX XXXX   XX XXXXXX XXXXXXX XXXXXXXXXXX  XXXX XXXXXXXXXXXXX XX X X X".toCharArray(),
        "XXXX XXXXX XXXXX XXXXXX XXXXXX    XXXXXX XXXXXXXXXXXXXXXX XXX   XX XXXXX  XXXXXX XX X X X".toCharArray(),
        "XXXX XXXXX       XXXXXX XXXXXXXXX XXXXXX XXXXXXXXXXX      X XXX    XXXXX  XXXXXX XX     X".toCharArray(),
        "XXXX XXXXXXXXXXXXXXXXXX XXXXXXXXX             XXXXXX XXX XX XXXXXX XXXXX XXXXXXX XXXXXX X".toCharArray(),
        "XXXX XXXXXXXXXXXXXXXXXX XXXXXXXXX XXXXXXXXXXXXXXXXXX XXX XX XX XXX XXXXX XXXXXX  XXXXXXXX".toCharArray(),
        "XXXX X        XXXXXXXXX XXXXXXXXX XXXXXXXXXXXXXXXXXX XXXXXX XX XXX XXXXX XXX    XXXXXXXXX".toCharArray(),
        "XXXX X XXXXXX XXXXXXXXX XXXXXXXXX XXXXXXXXXXXXXXXX          XX XXX XXXXX XXXX XXXXXXXXXXX".toCharArray(),
        "XXXX X XXXXXX XXXXXXXXX                   XXXXXXXX XXXXXXXX XXXXXX XXXXX XXXX XXXX    XXX".toCharArray(),
        "XXXX X XXXXXX XXXXXXXXXXXXXXXX XXXXXXXXXX XXXXX    XXXXXXXX XXXXXX XXXXXXXXXX XXXX XX XXX".toCharArray(),
        "XXXX X XXXXXX XXXX             XXXX XX XX XXXXX XXXXXXXXXXX XXXXXX XXXXXXXXXX XXXX XX XXX".toCharArray(),
        "XXXX X XXXXXXXXXXX XXXXXXXXXXX XXXX XX XX XXXXX XXXXXXXXXXXXXXXXXX XXXXXXXXXX      XX XXX".toCharArray(),
        "XXXX X             XXXXXXXXXXX XXXX XX XX                          XXXXXXXXXXXXXXXXXX XXX".toCharArray(),
        "XXXX XXXXXXXXXXXXX             XXXX XX XX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX XXX".toCharArray(),
        "XXXX     XXXXXXXXXXXXXXXXXXXXXXXXXX XX XX XXXXXXXXXXXXXXXXXXXX XXXXXXXXXX             XXX".toCharArray(),
        "XX   XXX      XXXXXXXXXXXXXXXX            XXXX    XXXXXXXXXXXX            XXXXXXXXXXXXXXX".toCharArray(),
        "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX".toCharArray(),};

    }


    /**
     * prints the maze and sleeps for a while only for visual effects.
     * @param theMaze
     */
    private static void printMaze(char[][] theMaze) {

        for (char[] row : theMaze) {
            for (char col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
        System.out.println("\n\n");        

        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException ex) {
            throw new Error(ex);
        }

    }

    private static void removeBreadCrumbs(char[][] theMaze) {

        for(int r= 0; r<theMaze.length; r++){
            for(int c= 0; c<theMaze[r].length; c++){
                if(theMaze[r][c]== BREADCRUMB){
                    theMaze[r][c]= PATH;
                }
            }
        }

    }

}



