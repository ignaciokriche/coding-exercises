package ar.com.kriche;

public class PascalTriangle {

    public static void main(String args[]) {
        int size = 8;
        System.out.println("Pascal Triangle of size " + size + ":");
        int triangle[][] = generatePascalTriangle(size);
        printPascalTriangle(triangle);
    }

    private static int[][] generatePascalTriangle(int size) {
        int triangle[][] = new int[size][];
        for (int r = 0; r < size; r++) {
            triangle[r] = new int[r + 1];
            triangle[r][0] = 1;
            for (int c = 1; c < r; c++) {
                triangle[r][c] = triangle[r - 1][c - 1] + triangle[r - 1][c];
            }
            triangle[r][r] = 1;
        }
        return triangle;
    }

    private static void printPascalTriangle(int triangle[][]) {
        final int size = triangle.length;
        final int maxNumber = triangle[size - 1][size / 2];
        final int maxDigits = (int) Math.floor(Math.log10(maxNumber) + 1);
        for (int r = 0; r < size; r++) {
            // print the offset for each row:
            System.out.printf("%" + ((maxDigits + 1) * (size - r)) + "s", "");
            // print the numbers with fixed width:
            for (int c = 0; c <= r; c++) {
                System.out.printf("%" + ((maxDigits + 1) * 2) + "d", triangle[r][c]);
            }
            System.out.println();
        }
    }

}
