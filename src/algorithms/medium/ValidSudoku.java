package algorithms.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/valid-sudoku">...</a>
 * This solution beats 26.20% other Java submissions' memory complexity
 * This solution beats 31.24% other Java submissions' runtime
 */
public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {

        List<Character> list = new LinkedList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') list.add(board[i][j]);
            }
            if (hasDuplicates(list)) return false;
            list.clear();
        }

        list = new LinkedList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') list.add(board[j][i]);
            }
            if (hasDuplicates(list)) return false;
            list.clear();
        }

        for (int xBox = 0; xBox <= 6; xBox += 3) {
            for (int yBox = 0; yBox <= 6; yBox += 3) {
                list = new LinkedList<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[i + xBox][j + yBox] != '.') list.add(board[i + xBox][j + yBox]);
                    }
                }
                if (hasDuplicates(list)) return false;
                list.clear();
            }
        }

        return true;
    }

    private static boolean hasDuplicates(List<Character> list) {
        return list.stream().distinct().count() != list.size();
    }
}
