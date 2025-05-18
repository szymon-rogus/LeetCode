package algorithms.easy.string;

/**
 * <a href="https://leetcode.com/problems/valid-palindrome">...</a>
 * This solution beats 33.59% other Java submissions' runtime
 * This solution beats 30.00% other Java submissions' memory complexity
 */
public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        /// getting rid of the non-alphanumeric elements
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }
}
