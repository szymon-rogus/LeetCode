package algorithms.easy.tree;

import dataStructures.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/minimum-distance-between-bst-nodes">...</a>
 * This solution beats 91.70% other Java submissions' memory complexity
 * This solution beats 15.03% other Java submissions' runtime
 */
public class MinimumDistanceBetweenBSTNodes {

    public static int minDiffInBST(TreeNode root) {
        List<Integer> list = new LinkedList<>();

        inorderTraversal(root, list);

        int diff = list.get(1) - list.get(0);
        for (int i = 1; i < list.size() - 1; i++) {
            if (diff == 0) return diff;
            int currentDiff = list.get(i + 1) - list.get(i);
            diff = Math.min(diff, currentDiff);
        }
        return diff;
    }

    private static void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;

        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }
}
