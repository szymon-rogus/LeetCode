package algorithms.medium.DP;

/**
 * <a href="https://leetcode.com/problems/paint-house">...</a>
 * This solution beats 100.00% other Java submissions' runtime
 * This solution beats 62.86% other Java submissions' memory complexity
 */
public class PaintHouse {

    public int minCost(int[][] costs) {
        int previousRed = costs[0][0];
        int previousBlue = costs[0][1];
        int previousGreen = costs[0][2];
        int red;
        int blue;
        int green;

        for (int i = 1; i < costs.length; i++) {
            red = Math.min(previousBlue, previousGreen) + costs[i][0];
            blue = Math.min(previousRed, previousGreen) + costs[i][1];
            green = Math.min(previousRed, previousBlue) + costs[i][2];
            previousRed = red;
            previousBlue = blue;
            previousGreen = green;
        }

        return Math.min(previousRed, Math.min(previousBlue, previousGreen));
    }
}
