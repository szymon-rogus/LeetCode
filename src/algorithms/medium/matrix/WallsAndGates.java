package algorithms.medium.matrix;

/**
 * <a href="https://leetcode.com/problems/walls-and-gates">...</a>
 * This solution beats 92.64% other Java submissions' runtime O(m*n)
 * This solution beats 15.18% other Java submissions' memory complexity O(m*n)
 */
public class WallsAndGates {

    public static void wallsAndGates(int[][] rooms) {

        /// first loop to start DFS or BFS from any gate
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    /// look up for all 4 neighbours
                    bfs(rooms, i - 1, j, 1);
                    bfs(rooms, i + 1, j, 1);
                    bfs(rooms, i, j - 1, 1);
                    bfs(rooms, i, j + 1, 1);
                }
            }
        }
    }

    private static void bfs(int[][] rooms, int i, int j, int distance) {
        /// check edges of box
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length) return;
        /// filter gates and obstacles
        if (rooms[i][j] == -1 || rooms[i][j] == 0) return;

        if (rooms[i][j] > distance) {
            rooms[i][j] = distance;
            /// follow up with neighbours
            bfs(rooms, i - 1, j, distance + 1);
            bfs(rooms, i + 1, j, distance + 1);
            bfs(rooms, i, j - 1, distance + 1);
            bfs(rooms, i, j + 1, distance + 1);
        }
    }
}
