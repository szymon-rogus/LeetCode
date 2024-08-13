package algorithms.medium.tree;

/**
 * <a href="https://leetcode.com/problems/unique-binary-search-trees">...</a>
 * This solution beats 60.61% other Java submissions' memory complexity
 * This solution beats 13.16% other Java submissions' runtime
 */
public class UniqueBinarySearchTrees {

    /**
     * Recursive solution here is not very fast, but it looks neat.
     * For every node we assume it's a root of a tree and then multiply recursive
     * return combination of it's left and right subtrees (Except of the smallest and the greatest
     * number as it can only handle left/right subtree respectively).
     */
    public int numTrees(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 5;

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i == 1 || i == n) {
                sum += numTrees(n - 1);
            } else {
                sum += numTrees(n - i) * numTrees(i - 1);
            }
        }

        return sum;
    }
}
