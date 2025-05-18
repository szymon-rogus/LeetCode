package dataStructures;

import java.util.LinkedHashMap;

/**
 * <a href="https://leetcode.com/problems/lru-cache">...</a>
 * This solution beats 47.82% other Java submissions' runtime
 * This solution beats 13.37% other Java submissions' memory complexity
 */
public class LRUCache {

    private final LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            int value = cache.remove(key);
            cache.putFirst(key, value);
            return cache.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.size() < capacity || cache.containsKey(key)) {
            cache.putFirst(key, value);
        } else {
            int mostRecent = cache.lastEntry().getKey();
            cache.remove(mostRecent);
            cache.putFirst(key, value);
        }
    }
}
