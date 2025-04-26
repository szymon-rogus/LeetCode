package algorithms.medium.matrix;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/spiral-matrix">...</a>
 * This solution beats 26.68% other Java submissions' memory complexity
 * This solution beats 100% other Java submissions' runtime
 */
public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int border = -101;
        int x = 0;
        int y = 0;
        int flag = 1;
        boolean step1;
        boolean step2;
        boolean step3;
        boolean step4;
        List<Integer> list = new LinkedList<>();

        while (true) {
            list.add(matrix[x][y]);
            matrix[x][y] = border;

            step1 = y + 1 < matrix[0].length && matrix[x][y + 1] != border;
            step2 = x + 1 < matrix.length && matrix[x + 1][y] != border;
            step3 = y - 1 >= 0 && matrix[x][y - 1] != border;
            step4 = x - 1 >= 0 && matrix[x - 1][y] != border;

            if (flag == 1 && step1) {
                y++;
            } else
            if (flag == 2 && step2) {
                x++;
            } else
            if (flag == 3 && step3) {
                y--;
            } else
            if (flag == 4 && step4) {
                x--;
            } else {
                if (step1) {
                    y++;
                    flag = 1;
                } else
                if (step2) {
                    x++;
                    flag = 2;
                } else
                if (step3) {
                    y--;
                    flag = 3;
                } else
                if (step4) {
                    x--;
                    flag = 4;
                } else {
                    break;
                }
            }

        }
        return list;
    }
}
