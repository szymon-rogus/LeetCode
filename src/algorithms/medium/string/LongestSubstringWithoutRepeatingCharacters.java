package algorithms.medium.string;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters">...</a>
 * This solution beats 5.01% other Java submissions' runtime
 * This solution beats 96.25% other Java submissions' memory complexity
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        int maxSubstring = 0;

        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.length() - i <= maxSubstring) {
                break;
            }
            int counter = 0;
            for (int j = i; j < s.length(); j++) {
                if (list.contains(s.charAt(j))) {
                    break;
                } else {
                    list.add(s.charAt(j));
                    counter++;
                }
            }

            list.clear();
            maxSubstring = Math.max(maxSubstring, counter);
        }
        return maxSubstring;
    }
}
