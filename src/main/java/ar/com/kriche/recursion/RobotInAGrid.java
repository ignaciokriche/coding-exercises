package ar.com.kriche.recursion;

/**
 * Robot in a Grid: Imagine a robot sitting on the upper left corner of a grid with r rows and c columns.
 * The robot can only move in two directions, right and down, but certain cells are "off limits" such that the robot
 * cannot step on them.
 * <p>
 * Design an algorithm to find a path for the robot from the top left to the bottom right.
 *
 * @author Kriche
 */
public class RobotInAGrid {

    public static final int OFF_LIMITS = 0;
    public static final int ALLOWED = OFF_LIMITS + 1;

    public static final String MOVE_RIGHT = "move right";
    public static final String MOVE_DOWN = "move down";
    public static final String SEPARATOR = "\n";

    public static String findPath(int grid[][]) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return null;
        }
        return findPath(grid, 0, 0);
    }

    private static String findPath(int grid[][], int currentRow, int currentCol) {

        int rows = grid.length;
        int cols = grid[0].length;

        // base case:
        if (currentRow == rows - 1 && currentCol == cols - 1) {
            // we are at the destination!
            return "";
        }

        // go to the right?
        if (currentCol + 1 < cols && grid[currentRow][currentCol + 1] != OFF_LIMITS) {
            String rightPath = findPath(grid, currentRow, currentCol + 1);
            if (rightPath != null) {
                if (rightPath.length() > 0) {
                    return MOVE_RIGHT + SEPARATOR + rightPath;
                }
                return MOVE_RIGHT;

            }
        }
        // go down ?
        if (currentRow + 1 < rows && grid[currentRow + 1][currentCol] != OFF_LIMITS) {
            String downPath = findPath(grid, currentRow + 1, currentCol);
            if (downPath != null) {
                if (downPath.length() > 0) {
                    return MOVE_DOWN + SEPARATOR + downPath;
                }
                return MOVE_DOWN;
            }
        }

        // dead end
        return null;

    }
    
}
