package algorithms.easy.string;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/word-pattern">...</a>
 * This solution beats 100.00% other Java submissions' runtime
 * This solution beats 66.57% other Java submissions' memory complexity
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        /// to compare in both direction
        HashMap<Character, String> patternMap = new HashMap<>();
        HashMap<String, Character> stringMap = new HashMap<>();

        char[] charArray = pattern.toCharArray();
        String[] stringArray = s.split(" ");

        if (charArray.length != stringArray.length) return false;

        for (int i = 0; i < charArray.length; i++) {

            /// when we already have this key, we have to check if the corresponding value is the same
            if (patternMap.containsKey(charArray[i])) {
                if (!patternMap.get(charArray[i]).equals(stringArray[i])) return false;
            } else if (stringMap.containsKey(stringArray[i])) {
                if (!stringMap.get(stringArray[i]).equals(charArray[i])) return false;
            } else {
                patternMap.put(charArray[i], stringArray[i]);
                stringMap.put(stringArray[i], charArray[i]);
            }
        }
        return true;
    }
}
