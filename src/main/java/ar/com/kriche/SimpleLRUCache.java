/**
 * Discards the least recently used items first.
 * The methods get and put must each run in O(1) average time complexity.
 *
 * @author Kriche
 */

package ar.com.kriche;

import java.util.Iterator;
import java.util.LinkedHashMap;


public class SimpleLRUCache {

    private final int capacity;

    /*
     * Normally we would need a doubly linked list and a map to guarantee constant time.
     * The map key will be the user key and it will point to the nodes of the list.
     * The list will keep track of the element to be removed (if capacity is full).
     * It is important that the list is doubly linked, so we can remove any node in constant time.
     * Here I'm using a LinkedHashMap for both the map and the list.
     * There could be some performance degradation for the {@code get} operation but overall I think it is acceptable.
     * According to its documentation:
     * This class provides all the optional Map operations, and
     * permits null elements. Like HashMap, it provides constant-time
     * performance for the basic operations ({@code add}, {@code contains} and
     * {@code remove}), assuming the hash function disperses elements
     * properly among the buckets.
     */
    private final LinkedHashMap<Integer, Integer> linkedHashMap;

    /**
     * Initialize the LRU cache with positive size capacity.
     *
     * @param capacity must be positive.
     */
    public SimpleLRUCache(int capacity) {
        this.capacity = capacity;
        linkedHashMap = new LinkedHashMap<>(capacity);
    }

    /**
     * @return the value of the key if the key exists, otherwise returns -1.
     */
    public int get(int key) {
        Integer value = linkedHashMap.get(key);
        if (value == null) {
            return -1;
        }
        // remove and put the element, so it will be the last one to be removed when the cache is full.
        linkedHashMap.remove(key);
        linkedHashMap.put(key, value);
        return key;
    }

    /**
     * Updates the value of the key if the key exists. Otherwise, add the key-value pair to the cache.
     * If the number of keys exceeds the capacity from this operation, evict the least recently used key.
     */
    public void put(int key, int value) {
        if (linkedHashMap.containsKey(key)) {
            // remove and put the element back, so it will be the last one to be removed when the cache is full.
            linkedHashMap.remove(key);
        } else if (linkedHashMap.size() == capacity) {
            // here I'm assuming the keySet will return an iterator guarantying order.
            Iterator<Integer> iterator = linkedHashMap.keySet().iterator();
            iterator.next();
            iterator.remove();
        }
        linkedHashMap.put(key, value);
    }

    public int size() {
        return linkedHashMap.size();
    }

}
