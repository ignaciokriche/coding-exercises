package ar.com.kriche;

/**
 * This code demonstrates how from a single array we can build a matrix, a cube, etc of any dimension.
 * The idea is to show how recursion can be used to achieve this. Also a non recursive solution is presented.
 * Normally the non recursive approach is preferred.
 *
 * @author Kriche
 */
public class MemoryArithmetic<E> {

    private int[] boundaries;
    private E[] memory;

    /**
     * Construct an array with the dimensions given.
     *
     * @param boundaries
     */
    public MemoryArithmetic(int... boundaries) {

        this.boundaries = boundaries;

        int dim = 1;
        for (int boundary : boundaries) {
            dim *= boundary;
        }

        memory = (E[]) new Object[dim];

    }

    /*
     * Including "Recursive" as part of the signature only for demo purposes.
     */
    public void setValueAtRecursive(E value, int... coordinates) {
        memory[getIndexRecursive(coordinates)] = value;
    }


    /*
     * Including "Recursive" as part of the signature only for demo purposes.
     */
    public E getValueAtRecursive(int... coordinates) {
        return memory[getIndexRecursive(coordinates)];
    }

    /*
     * Including "Iterative" as part of the signature only for demo purposes.
     */
    public void setValueAtIterative(E value, int... coordinates) {
        memory[getIndexIterative(coordinates)] = value;
    }


    /*
     * Including "Iterative" as part of the signature only for demo purposes.
     */
    public E getValueAtIterative(int... coordinates) {
        return memory[getIndexIterative(coordinates)];
    }

    /*
     * Including "Iterative" as part of the signature only for demo purposes.
     */
    private int getIndexIterative(int... coordinates) {

        int spaceDimensions = coordinates.length;

        // a one dimension array:
        if (spaceDimensions == 1) {
            return coordinates[0];
        }

        // a matrix:        
        if (spaceDimensions == 2) {
            return coordinates[0] * boundaries[1] + coordinates[1];
        }


        int index = boundaries[1] * coordinates[0] + coordinates[1];
        int offset = boundaries[1] * boundaries[0];

        for (int i = 2; i < spaceDimensions; i++) {
            index += offset * coordinates[i];
            offset *= boundaries[i];
        }

        return index;

    }

    /*
     * Including "Recursive" as part of the signature only for demo purposes.
     */
    private int getIndexRecursive(int coordinates[]) {
        return getIndexRecursive(coordinates, coordinates.length);
    }

    /*
     * Including "Recursive" as part of the signature only for demo purposes.
     */
    private int getIndexRecursive(int coordinates[], int spaceDimensions) {

        if (spaceDimensions == 1) {
            //one simple array of objects
            return coordinates[0];
        }

        // a matrix:
        if (spaceDimensions == 2) {
            return coordinates[0] * boundaries[1] + coordinates[1];
        }

        // cube or more dimensions, remove one dimension and call myself
        int currentDimension = spaceDimensions - 1;

        int spaceSize = 1;
        for (int t = 0; t < currentDimension; t++) {
            spaceSize *= boundaries[t];
        }

        return spaceSize * coordinates[currentDimension] + getIndexRecursive(coordinates, currentDimension);

    }
}
