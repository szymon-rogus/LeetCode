package algorithms.easy.tree;

import dataStructures.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/binary-tree-paths">...</a>
 * This solution beats 13.46% other Java submissions' runtime
 * This solution beats 67.08% other Java submissions' memory complexity
 */
public class BinaryTreePaths {

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new LinkedList<>();
        String path = "";

        ///  for every recursive execution we pass final list and Path currently being built
        binaryTreePaths(list, path, root);

        return list;
    }

    private static void binaryTreePaths(List<String> list, String path, TreeNode root) {
        /// basic case when path ends
        if (root.left == null && root.right == null) {
            path = path + root.val;
            list.add(path);
        }

        if (root.left != null) {
            binaryTreePaths(list, path + root.val + "->", root.left);
        }
        if (root.right != null) {
            binaryTreePaths(list, path + root.val + "->", root.right);
        }
    }
}
