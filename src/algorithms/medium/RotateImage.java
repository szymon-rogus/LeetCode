package algorithms.medium;

/**
 * <a href="https://leetcode.com/problems/rotate-image">...</a>
 * This solution beats 58.60% other Java submissions' memory complexity
 * This solution beats 100% other Java submissions' runtime
 */
public class RotateImage {

    public static void rotate(int[][] matrix) {
        // transpose
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reverse
        for (int i = 0; i < matrix.length; i++) {
            int pointerStart = 0;
            int pointerEnd = matrix.length - 1;
            while (pointerStart < pointerEnd) {
                int temp = matrix[i][pointerStart];
                matrix[i][pointerStart] = matrix[i][pointerEnd];
                matrix[i][pointerEnd] = temp;
                pointerStart++;
                pointerEnd--;
            }
        }
    }
}
