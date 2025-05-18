package algorithms.medium.matrix;

/**
 * <a href="https://leetcode.com/problems/number-of-islands">...</a>
 * This solution beats 99.77% other Java submissions' runtime
 * This solution beats 60.87% other Java submissions' memory complexity
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                /// if we found a land, we have to mark this island as 'visited' via BFS
                if (grid[x][y] == '1') {
                    islands++;
                    search(grid, x, y);
                }
            }
        }

        return islands;
    }

    private void search(char[][] grid, int x, int y) {
        /// mark as visited
        grid[x][y] = 'x';

        /// propagate visit on neighbours
        if (x > 0 && grid[x - 1][y] == '1') search(grid, x - 1, y);
        if (x < grid.length - 1 && grid[x + 1][y] == '1') search(grid, x + 1, y);
        if (y > 0 && grid[x][y - 1] == '1') search(grid, x, y - 1);
        if (y < grid[x].length - 1 && grid[x][y + 1] == '1') search(grid, x, y + 1);
    }
}
