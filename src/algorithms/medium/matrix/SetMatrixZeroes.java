package algorithms.medium.matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/set-matrix-zeroes">...</a>
 * This solution beats 15.95% other Java submissions' memory complexity
 * This solution beats 18.32% other Java submissions' runtime
 */
public class SetMatrixZeroes {

    /// brute force approach O(n*m) runtime and O(n + m) memory - TODO: improve!
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();

        /// rows
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rows.contains(i) || columns.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
