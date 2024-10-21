package algorithms.medium;

/**
 * <a href="https://leetcode.com/problems/minimum-path-sum">...</a>
 * This solution beats 21.82% other Java submissions' memory complexity
 * This solution beats 31.85% other Java submissions' runtime
 */
public class MinimumPathSum {

    public static int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j != 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (i != 0 && j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else if (i != 0) {
                    grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }
}
