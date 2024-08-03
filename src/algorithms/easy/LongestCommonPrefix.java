package algorithms.easy;

/**
 * <a href="https://leetcode.com/problems/longest-common-prefix">...</a>
 * This solution beats 12.47% other Java submissions' memory complexity
 * This solution beats 74% other Java submissions' runtime
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strings) {
        String reference = strings[0];
        for (int i = 0; i < reference.length(); i++) {
            for (String string : strings) {
                if (string.length() <= i || string.charAt(i) != reference.charAt(i)) {
                    return reference.substring(0, i);
                }
            }
        }
        return reference;
    }
}
