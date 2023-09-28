package ar.com.kriche;

import org.jetbrains.annotations.NotNull;

/**
 * Matrix related exercises.
 *
 * @author Kriche
 */
public class Matrix {

    /**
     * Given a NxN matrix, write a method to rotate the image by 90 degrees.
     * Can you do this in place?
     */
    public static void rotateSquareMatrix(@NotNull int[][] matrix) {

        if (matrix.length == 0) {
            return;
        }

        // one way to achieve this (in place) is to move each cell at a time to its final position.
        // start by rotating the outer layer: this is the borders of the matrix,
        // then move one layer inside and repeat until you reach the center.

        // diagonal to transverse the layers, only up to the center not inclusive:
        for (int diagonal = 0; diagonal <= matrix.length / 2; diagonal++) {

            // cover the columns on the current layer (from right to left):
            for (int col = matrix.length - 1 - diagonal; col > diagonal; col--) {

                int sourceRow = diagonal;
                int sourceCol = col;
                int currentValue = matrix[sourceRow][sourceCol];

                // this inner loop is always 4: left, down, right and up directions:
                for (int border = 0; border < 4; border++) {

                    // in here we have a source cell: matrix[sourceRow][sourceCol]
                    // and we calculate the target cell:
                    int targetRow, targetCol;
                    targetRow = (matrix.length - 1) - sourceCol;
                    targetCol = sourceRow;

                    // System.out.println("(" + sourceRow + ";" + sourceCol + ")->(" + targetRow + ";" + targetCol + ")");

                    // swap:
                    int nextValue = matrix[targetRow][targetCol];
                    matrix[targetRow][targetCol] = currentValue;
                    currentValue = nextValue;

                    // now we continue rotating using the target cell as the next one to be rotated (source cell):
                    sourceRow = targetRow;
                    sourceCol = targetCol;
                }
            }
        }
    }

    /**
     * if an element in matrix is 0, its entire row and column are set to 0.
     */
    public static void zeroMatrix(@NotNull int[][] matrix) {

        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        boolean[] rowsToZero = new boolean[matrix.length];
        boolean[] colToZero = new boolean[matrix[0].length];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] == 0) {
                    rowsToZero[r] = true;
                    colToZero[c] = true;
                }
            }
        }

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (rowsToZero[r] || colToZero[c]) {
                    matrix[r][c] = 0;
                }
            }
        }
    }

}
