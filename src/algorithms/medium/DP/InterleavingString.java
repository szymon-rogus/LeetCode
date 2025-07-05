package algorithms.medium.DP;

/**
 * <a href="https://leetcode.com/problems/interleaving-string">...</a>
 * This solution beats 52.72% other Java submissions' runtime
 * This solution beats 43.02% other Java submissions' memory complexity
 */
public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        /// edge cases for empty strings
        if (s1.isEmpty()) return s2.equals(s3);
        if (s2.isEmpty()) return s1.equals(s3);
        if (s3.isEmpty()) return false;
        if (s1.length() + s2.length() != s3.length()) return false;

        ///  dp matrix to hold our way to right bottom corner
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        dp[0][0] = 1;

        /// if we can reach right bottom corner, there is a way to interleave s1 ans s2
        for (int x = 0; x <= s1.length(); x++) {
            for (int y = 0; y <= s2.length(); y++) {
                if (dp[x][y] == 0) continue;

                if (x < s1.length() && s1.charAt(x) == s3.charAt(x + y)) dp[x + 1][y] = 1;
                if (y < s2.length() && s2.charAt(y) == s3.charAt(x + y)) dp[x][y + 1] = 1;
            }
        }

        return dp[s1.length()][s2.length()] == 1;
    }
}
