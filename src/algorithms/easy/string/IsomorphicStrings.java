package algorithms.easy.string;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/isomorphic-strings">...</a>
 * This solution beats 31.21% other Java submissions' runtime
 * This solution beats 37.75% other Java submissions' memory complexity
 */
public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        ///  not very efficient
        HashMap<Character, Character> mapKeys = new HashMap<>();
        HashMap<Character, Character> mapValues = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            char value = t.charAt(i);

            ///  have to check transition in both way
            if (mapKeys.containsKey(key)) {
                char existingValue = mapKeys.get(key);
                if (existingValue != value) return false;
            } if (mapValues.containsKey(value)) {
                char existingValue = mapValues.get(value);
                if (existingValue != key) return false;
            } else {
                mapKeys.put(key, value);
                mapValues.put(value, key);
            }
        }
        return true;
    }
}
