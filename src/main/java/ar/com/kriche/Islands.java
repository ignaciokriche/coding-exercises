/*
 * Given an m x n matrix of "land" and "water", return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 *
 * @author Kriche
 */

package ar.com.kriche;

public class Islands {

    /**
     * @param map not empty and rectangular array of arrays of boolean representing the map of islands where
     *            true denotes land and false denotes water.
     * @return the amount of islands.
     */
    public static int countIslands(boolean[][] map) {
        boolean visitedPoints[][] = new boolean[map.length][map[0].length];
        int islands = 0;
        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[0].length; c++) {
                boolean point = map[r][c];
                if (point && !visitedPoints[r][c]) {
                    islands++;
                    visit(map, visitedPoints, r, c);
                }
            }
        }
        return islands;
    }

    private static void visit(boolean[][] map, boolean[][] visitedPoints, int r, int c) {

        visitedPoints[r][c] = true;

        for (int visitRow = r - 1; visitRow <= r + 1; visitRow++) {
            for (int visitCol = c - 1; visitCol <= c + 1; visitCol++) {

                if (visitRow == r && visitCol == c) {
                    continue; // skip current point
                }

                // check limits:
                if (visitRow < 0 || visitCol < 0) {
                    continue;
                }
                if (visitRow == visitedPoints.length || visitCol == visitedPoints[0].length) {
                    continue;
                }

                if (map[visitRow][visitCol] && !visitedPoints[visitRow][visitCol]) {
                    visit(map, visitedPoints, visitRow, visitCol);
                }

            }
        }
    }

}
