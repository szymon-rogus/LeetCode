package algorithms.medium.DP;

import java.util.List;

/**
 * <a href="https://leetcode.com/problems/triangle">...</a>
 * This solution beats 17.20% other Java submissions' runtime
 * This solution beats 21.52% other Java submissions' memory complexity
 */
public class Triangle {

    /**
     * Top-bottom solution with memoization. Not the best, but optimal with runtime complexity O(n^2)
     * @param triangle triangle as List of lists
     * @return minimum path
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> previousRow = triangle.getFirst();
        int result = triangle.getFirst().getFirst();

        for (int i = 1; i < triangle.size(); i++) {

            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                if (j == 0) {
                    int value = row.getFirst() + previousRow.getFirst();
                    row.set(0, value);
                } else if (j == row.size() - 1) {
                    int value = row.get(j) + previousRow.get(j - 1);
                    row.set(j, value);
                } else {
                    int value = row.get(j) + Math.min(previousRow.get(j), previousRow.get(j - 1));
                    row.set(j, value);
                }
            }
            previousRow = row;
            if (i == triangle.size() - 1) {
                result = previousRow.stream().min(Integer::compare).get();
            }
        }
        return result;
    }
}
