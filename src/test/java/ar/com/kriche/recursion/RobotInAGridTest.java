package ar.com.kriche.recursion;

import org.junit.jupiter.api.Test;

import static ar.com.kriche.recursion.RobotInAGrid.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Kriche
 */
public class RobotInAGridTest {

    @Test
    public void findPathTest() {

        int grid[][] =
                new int[][]{
                        {ALLOWED, ALLOWED, OFF_LIMITS, OFF_LIMITS, OFF_LIMITS},
                        {OFF_LIMITS, ALLOWED, OFF_LIMITS, OFF_LIMITS, OFF_LIMITS},
                        {OFF_LIMITS, ALLOWED, ALLOWED, ALLOWED, ALLOWED},
                        {OFF_LIMITS, OFF_LIMITS, ALLOWED, OFF_LIMITS, OFF_LIMITS},
                        {OFF_LIMITS, OFF_LIMITS, ALLOWED, ALLOWED, OFF_LIMITS},
                        {OFF_LIMITS, OFF_LIMITS, OFF_LIMITS, ALLOWED, ALLOWED},
                };

        String actualPath = findPath(grid);

        String expectedPath =
                MOVE_RIGHT + SEPARATOR +
                        MOVE_DOWN + SEPARATOR +
                        MOVE_DOWN + SEPARATOR +
                        MOVE_RIGHT + SEPARATOR +
                        MOVE_DOWN + SEPARATOR +
                        MOVE_DOWN + SEPARATOR +
                        MOVE_RIGHT + SEPARATOR +
                        MOVE_DOWN + SEPARATOR +
                        MOVE_RIGHT;

        assertEquals(expectedPath, actualPath);
    }

    @Test
    public void findPathDeadEndTest() {

        int grid[][] =
                new int[][]{
                        {ALLOWED, ALLOWED, OFF_LIMITS, OFF_LIMITS, OFF_LIMITS},
                        {OFF_LIMITS, ALLOWED, OFF_LIMITS, OFF_LIMITS, OFF_LIMITS},
                        {OFF_LIMITS, ALLOWED, ALLOWED, ALLOWED, ALLOWED},
                        {OFF_LIMITS, OFF_LIMITS, ALLOWED, OFF_LIMITS, OFF_LIMITS},
                        {OFF_LIMITS, OFF_LIMITS, ALLOWED, ALLOWED, OFF_LIMITS},
                        {OFF_LIMITS, OFF_LIMITS, OFF_LIMITS, OFF_LIMITS, ALLOWED},
                };

        String actualPath = findPath(grid);
        String expectedPath = null;
        assertEquals(expectedPath, actualPath);
    }

}