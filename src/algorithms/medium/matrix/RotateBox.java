package algorithms.medium.matrix;

/**
 * <a href="https://leetcode.com/problems/rotating-the-box">...</a>
 * This solution beats 85.62% other Java submissions' memory complexity
 * This solution beats 91.49% other Java submissions' runtime
 */
public class RotateBox {

    public char[][] rotateTheBox(char[][] boxGrid) {
        char stone = '#';
        char obstacle = '*';
        int rows = boxGrid.length;
        int columns = boxGrid[0].length;

        /// move stones sequence
        for (int i = 0; i < rows; i++) {
            int bottom = columns - 1;
            for (int j = columns - 1; j >= 0; j--) {
                /// we need to update new bottom where the stones will drop
                if (boxGrid[i][j] == obstacle) {
                    bottom = j - 1;
                }
                /// for the encountered stone, we have to switch it with current bottom
                /// and then update bottom to be one above the dropped stone
                if (boxGrid[i][j] == stone) {
                    char temp = boxGrid[i][bottom];
                    boxGrid[i][bottom] = boxGrid[i][j];
                    boxGrid[i][j] = temp;

                    bottom--;
                }
            }
        }

        /// rotateBox sequence
        char[][] rotatedBox = new char[columns][rows];
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                rotatedBox[i][j] = boxGrid[rows - 1 - j][i];
            }
        }

        return rotatedBox;
    }
}
