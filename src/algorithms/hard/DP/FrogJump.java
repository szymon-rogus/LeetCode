package algorithms.hard.DP;

/**
 * <a href="https://leetcode.com/problems/paint-fence">...</a>
 * This solution beats 15.27% other Java submissions' runtime
 * This solution beats 10.08% other Java submissions' memory complexity
 */
public class FrogJump {

    public boolean canCross(int[] stones) {
        int[][] dp = new int[stones.length][stones.length];
        dp[0][1] = 1;

        for (int i = 0; i < stones.length - 1; i++) {
            for (int j = 1; j < stones.length; j++) {
                if (dp[i][j] == 0) continue;
                int jump = dp[i][j];

                for (int k = i + 1; k < stones.length; k++) {
                    if (stones[k] == stones[i] + jump) {
                        dp[k][jump] = jump;
                        dp[k][jump - 1] = jump - 1;
                        if (jump < stones.length - 1) dp[k][jump + 1] = jump + 1;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < stones.length; i++) {
            if (dp[stones.length - 1][i] != 0) return true;
        }
        return false;
    }
}
