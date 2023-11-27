package ar.com.kriche;

import org.junit.jupiter.api.Test;

import static ar.com.kriche.Islands.countIslands;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IslandsTest {

    @Test
    public void noIslandTest() {
        boolean map[][] = {
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
        };
        assertEquals(0, countIslands(map));
    }

    @Test
    public void oneIslandTest() {
        boolean map[][] = {
                {false, false, false, false, false},
                {false, false, true, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
        };
        assertEquals(1, countIslands(map));
    }

    @Test
    public void islandTest() {
        boolean map[][] = {
                {true, false, true, false, false, false},
                {true, false, false, false, false, true},
                {true, false, true, false, false, true},
                {true, true, false, false, false, true},
                {true, false, false, false, false, true},
                {false, false, false, false, false, true},
                {true, false, false, false, false, false},
                {true, false, false, false, false, true},
                {true, false, false, false, false, true},
        };
        assertEquals(5, countIslands(map));
    }

    @Test
    public void allLandTest() {
        boolean map[][] = {
                {true, true, true},
                {true, true, true},
                {true, true, true},
                {true, true, true},
        };
        assertEquals(1, countIslands(map));
    }

}