package algorithms.medium.matrix;

/**
 * <a href="https://leetcode.com/problems/surrounded-regions">...</a>
 * This solution beats 84.11% other Java submissions' runtime
 * This solution beats 58.89% other Java submissions' memory complexity
 */
public class SurroundedRegions {

    public void solve(char[][] board) {
        /// first two loops - mark regions from boundaries as 'M'
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                search(board, i, 0);
            }
            if (board[i][board[0].length - 1] == 'O') {
                search(board, i, board[0].length - 1);
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                search(board, 0, i);
            }
            if (board[board.length - 1][i] == 'O') {
                search(board, board.length - 1, i);
            }
        }

        /// Only 'M' regions stay as 'O', other are inside and can be replaced with 'X'
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (board[x][y] == 'M') {
                    board[x][y] = 'O';
                } else {
                    board[x][y] = 'X';
                }
            }
        }
    }

    private void search(char[][] board, int x, int y) {
        board[x][y] = 'M';

        if (x > 0 && board[x - 1][y] == 'O') search(board, x - 1, y);
        if (x < board.length - 1 && board[x + 1][y] == 'O') search(board, x + 1, y);
        if (y > 0 && board[x][y - 1] == 'O') search(board, x, y - 1);
        if (y < board[x].length - 1 && board[x][y + 1] == 'O') search(board, x, y + 1);
    }
}
