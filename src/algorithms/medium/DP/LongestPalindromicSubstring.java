package algorithms.medium.DP;

/**
 * <a href="https://leetcode.com/problems/longest-palindromic-substring">...</a>
 * This solution beats 46.32% other Java submissions' runtime
 * This solution beats 76.88% other Java submissions' memory complexity
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int diff = 1;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        /// absolutely horrifying
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (j == i + 1) {
                    dp[i][j] = s.charAt(j) == s.charAt(i);
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                }

                if (dp[i][j] && j - i + 1 > diff) {
                    diff = j - i + 1;
                    start = i;
                }
            }
        }

        return s.substring(start, start + diff);
    }
}
