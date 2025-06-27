package algorithms.medium.matrix;

/**
 * <a href="https://leetcode.com/problems/bomb-enemy">...</a>
 * This solution beats 57.66% other Java submissions' runtime
 * This solution beats 40.55% other Java submissions' memory complexity
 */
public class BombEnemy {

    /// Sick but optimal
    public int maxKilledEnemies(char[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        int maxCount = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                dp[i][j] = 0;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            int enemies = 0;
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 'E') enemies++;
                if (grid[i][j] == '0') dp[i][j] += enemies;
                if (grid[i][j] == 'W') enemies = 0;
            }
        }
        for (int i = 0; i < grid.length; i++) {
            int enemies = 0;
            for (int j = grid[i].length - 1; j >= 0; j--) {
                if (grid[i][j] == 'E') enemies++;
                if (grid[i][j] == '0') dp[i][j] += enemies;
                if (grid[i][j] == 'W') enemies = 0;
            }
        }
        for (int i = 0; i < grid[0].length; i++) {
            int enemies = 0;
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == 'E') enemies++;
                if (grid[j][i] == '0') dp[j][i] += enemies;
                if (grid[j][i] == 'W') enemies = 0;
            }
        }
        for (int i = 0; i < grid[0].length; i++) {
            int enemies = 0;
            for (int j = grid.length - 1; j >= 0; j--) {
                if (grid[j][i] == 'E') enemies++;
                if (grid[j][i] == '0') {
                    dp[j][i] += enemies;
                    maxCount = Math.max(dp[j][i], maxCount);
                }
                if (grid[j][i] == 'W') enemies = 0;
            }
        }

        return maxCount;
    }
}
