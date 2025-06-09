package algorithms.easy.tree;

import dataStructures.TreeNode;

/**
 * <a href="https://leetcode.com/problems/evaluate-boolean-binary-tree">...</a>
 * This solution beats 100% other Java submissions' runtime
 * This solution beats 7.90% other Java submissions' memory complexity
 */
public class EvaluateBooleanBinaryTree {

    public boolean evaluateTree(TreeNode root) {
        if (root.left == null && root.right == null) return root.val == 1;

        /// each node have either 0 or 2 children - constraint
        if (root.val == 2) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        }
        return evaluateTree(root.left) && evaluateTree(root.right);
    }
}
