package algorithms.easy.string;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/ransom-note">...</a>
 * This solution beats 26.53% other Java submissions' memory complexity
 * This solution beats 23.54% other Java submissions' runtime
 */
public class ValidAnagram {

    /// Solution better than sorting, but worse than bit manipulation
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        if (s.length() != t.length()) return false;

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            /// from this String we add its char existence in map
            if (!map.containsKey(sChar)) {
                map.put(sChar, 1);
            } else {
                int count = map.get(sChar);
                if (count == -1) {
                    map.remove(sChar);
                } else {
                    map.put(sChar, ++count);
                }
            }

            ///  from this String we subtract char existence in map
            if (!map.containsKey(tChar)) {
                map.put(tChar, -1);
            } else {
                int count = map.get(tChar);
                if (count == 1) {
                    map.remove(tChar);
                } else {
                    map.put(tChar, --count);
                }
            }
        }

        return map.isEmpty();
    }
}
