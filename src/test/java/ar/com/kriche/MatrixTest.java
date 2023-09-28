package ar.com.kriche;

import org.junit.jupiter.api.Test;

import static ar.com.kriche.Matrix.rotateSquareMatrix;
import static ar.com.kriche.Matrix.zeroMatrix;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author Kriche
 */
public class MatrixTest {

    @Test
    public void rotateSquareMatrix0DTest() {
        int[][] matrix = new int[][]{{}};
        rotateSquareMatrix(matrix);
        int[][] expected = new int[][]{{}};
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void rotateSquareMatrix1DTest() {
        int[][] matrix = new int[][]{{1}};
        rotateSquareMatrix(matrix);
        int[][] expected = new int[][]{{1}};
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void rotateSquareMatrix2DTest() {
        int[][] matrix =
                new int[][]{
                        {1, 2},
                        {3, 4}
                };
        rotateSquareMatrix(matrix);
        int[][] expected =
                new int[][]{
                        {2, 4},
                        {1, 3},
                };
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void rotateSquareMatrix3DTest() {
        int[][] matrix =
                new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                };
        rotateSquareMatrix(matrix);
        int[][] expected =
                new int[][]{
                        {3, 6, 9},
                        {2, 5, 8},
                        {1, 4, 7}
                };
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void rotateSquareMatrix4DTest() {
        int[][] matrix =
                new int[][]{
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}
                };
        rotateSquareMatrix(matrix);
        int[][] expected =
                new int[][]{
                        {4, 8, 12, 16},
                        {3, 7, 11, 15},
                        {2, 6, 10, 14},
                        {1, 5, 9, 13}
                };
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void zeroMatrix0DTest() {
        int[][] matrix = new int[][]{{}};
        zeroMatrix(matrix);
        int[][] expected = new int[][]{{}};
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void zeroMatrix1DzeroTest() {
        int[][] matrix = new int[][]{{0}};
        zeroMatrix(matrix);
        int[][] expected = new int[][]{{0}};
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void zeroMatrix1DNoZeroTest() {
        int[][] matrix = new int[][]{{1}};
        zeroMatrix(matrix);
        int[][] expected = new int[][]{{1}};
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void zeroMatrix2DNoZeroTest() {
        int[][] matrix =
                new int[][]{
                        {1, 1},
                        {1, 1}
                };
        zeroMatrix(matrix);
        int[][] expected =
                new int[][]{
                        {1, 1},
                        {1, 1}
                };
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void zeroMatrix2DZeroTest() {
        int[][] matrix =
                new int[][]{
                        {1, 1}, {0, 1}
                };
        zeroMatrix(matrix);
        int[][] expected =
                new int[][]{
                        {0, 1},
                        {0, 0}
                };
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void zeroMatrix4DZeroTest() {
        int[][] matrix =
                new int[][]{
                        {1, 2, 3, 4},
                        {5, 0, 7, 8},
                        {9, 10, 0, 12},
                        {13, 14, 15, 16}
                };
        zeroMatrix(matrix);
        int[][] expected =
                new int[][]{
                        {1, 0, 0, 4},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {13, 0, 0, 16}
                };
        assertArrayEquals(expected, matrix);
    }

}
