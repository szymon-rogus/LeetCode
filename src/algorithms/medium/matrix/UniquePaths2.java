package algorithms.medium.matrix;

public class UniquePaths2 {

    /**
     * <a href="https://leetcode.com/problems/unique-paths-ii">...</a>
     * This solution beats 95.76% other Java submissions' memory complexity
     * This solution beats 100% other Java submissions' runtime
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;

        if (obstacleGrid.length == 1 && obstacleGrid[0].length == 1) return Math.abs(obstacleGrid[0][0] - 1);
        obstacleGrid[0][0] = 1;

        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {
                if (i == 0 && j == 0) continue;
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                    continue;
                }
                if (i == 0) {
                    obstacleGrid[i][j] += obstacleGrid[i][j - 1];
                } else if (j == 0) {
                    obstacleGrid[i][j] += obstacleGrid[i - 1][j];
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i][j] + obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }

        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
