package algorithms.easy.DP;

/**
 * <a href="https://leetcode.com/problems/maximum-repeating-substring">...</a>
 * This solution beats 55.40% other Java submissions' runtime
 * This solution beats 19.94% other Java submissions' memory complexity
 */
public class MaximumRepeatingSubstring {

    public int maxRepeating(String sequence, String word) {
        int[] dp = new int[sequence.length() + 1];
        int solution = 0;

        for (int i = 0; i <= sequence.length() - word.length(); i++) {
            if (sequence.startsWith(word, i)) {
                dp[i + word.length()] = dp[i] + 1;
            }
        }

        for (int i = 0; i <= sequence.length(); i++) {
            if (dp[i] > solution) solution = dp[i];
        }

        return solution;
    }
}
