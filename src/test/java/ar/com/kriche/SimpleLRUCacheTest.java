package ar.com.kriche;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Kriche
 */
public class SimpleLRUCacheTest {

    @Test
    public void capacityTest() {

        int capacity = 3;
        SimpleLRUCache theTested = new SimpleLRUCache(capacity);

        assertEquals(0, theTested.size());
        theTested.put(1, 1);
        assertEquals(1, theTested.size());

        theTested.put(2, 2);
        assertEquals(2, theTested.size());

        theTested.put(3, 3);
        assertEquals(capacity, theTested.size());

        theTested.put(4, 4);
        theTested.put(5, 5);
        assertEquals(capacity, theTested.size());
    }

    @Test
    public void discardsLRUTest() {

        int capacity = 5;
        SimpleLRUCache theTested = new SimpleLRUCache(capacity);

        theTested.put(1, 1);
        theTested.put(2, 2);
        theTested.put(3, 3);
        theTested.put(4, 4);
        theTested.put(5, 5);
        theTested.put(6, 6);
        theTested.put(7, 7);

        assertEquals(-1, theTested.get(1));
        assertEquals(-1, theTested.get(2));
        assertEquals(3, theTested.get(3));
        assertEquals(4, theTested.get(4));
        assertEquals(5, theTested.get(5));
        assertEquals(6, theTested.get(6));
        assertEquals(7, theTested.get(7));
    }

    @Test
    public void getRefreshKeyTest() {

        int capacity = 5;
        SimpleLRUCache theTested = new SimpleLRUCache(capacity);

        theTested.put(1, 1);
        theTested.put(2, 2);
        theTested.put(3, 3);
        theTested.put(4, 4);
        theTested.put(5, 5);
        assertEquals(1, theTested.get(1));
        theTested.put(6, 6);
        theTested.put(7, 7);

        assertEquals(1, theTested.get(1));
        assertEquals(-1, theTested.get(2));
        assertEquals(-1, theTested.get(3));
        assertEquals(4, theTested.get(4));
        assertEquals(5, theTested.get(5));
        assertEquals(6, theTested.get(6));
        assertEquals(7, theTested.get(7));
    }

    @Test
    public void putRefreshKeyTest() {

        int capacity = 5;
        SimpleLRUCache theTested = new SimpleLRUCache(capacity);

        theTested.put(1, 1);
        theTested.put(2, 2);
        theTested.put(3, 3);
        theTested.put(4, 4);
        theTested.put(5, 5);
        theTested.put(1, 1);
        theTested.put(6, 6);
        theTested.put(7, 7);

        assertEquals(1, theTested.get(1));
        assertEquals(-1, theTested.get(2));
        assertEquals(-1, theTested.get(3));
        assertEquals(4, theTested.get(4));
        assertEquals(5, theTested.get(5));
        assertEquals(6, theTested.get(6));
        assertEquals(7, theTested.get(7));
    }

}