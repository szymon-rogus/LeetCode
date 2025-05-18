package algorithms.medium.tree;

import dataStructures.Pair;
import dataStructures.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/binary-tree-level-order-traversal">...</a>
 * This solution beats 15.46% other Java submissions' runtime
 * This solution beats 57.31% other Java submissions' memory complexity
 */
public class BinaryTreeLevelOrderTraversal {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new LinkedList<>();

        List<List<Integer>> list = new LinkedList<>();
        Stack<Pair<Integer, TreeNode>> stack = new Stack<>();
        stack.push(new Pair<>(1, root));

        while (!stack.isEmpty()) {
            Pair<Integer, TreeNode> pair = stack.pop();

            if (list.size() < pair.first) {
                List<Integer> newLevel = new LinkedList<>();
                newLevel.add(pair.second.val);
                list.add(newLevel);
            } else {
                list.get(pair.first - 1).add(pair.second.val);
            }

            if (pair.second.right != null) stack.push(new Pair<>(pair.first + 1, pair.second.right));
            if (pair.second.left != null) stack.push(new Pair<>(pair.first + 1, pair.second.left));
        }
        return list;
    }
}
