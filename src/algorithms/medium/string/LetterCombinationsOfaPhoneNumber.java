package algorithms.medium.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number">...</a>
 * This solution beats 65.31% other Java submissions' runtime
 * This solution beats 56.91% other Java submissions' memory complexity
 */
public class LetterCombinationsOfaPhoneNumber {

    private static final Map<Character, String> map = Map.of('2', "a:b:c",
            '3', "d:e:f",
            '4', "g:h:i",
            '5', "j:k:l",
            '6', "m:n:o",
            '7', "p:q:r:s",
            '8', "t:u:v",
            '9', "w:x:y:z"
    );

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();
        if (digits.length() == 1) return List.of(map.get(digits.charAt(0)).split(":"));

        List<String> combinations = letterCombinations(digits.substring(1));
        String[] actual = map.get(digits.charAt(0)).split(":");
        List<String> newCombs = new ArrayList<>();

        for (String c : actual) {
            for (String s : combinations) {
                s = c + s;
                newCombs.add(s);
            }
        }
        return newCombs;
    }
}
