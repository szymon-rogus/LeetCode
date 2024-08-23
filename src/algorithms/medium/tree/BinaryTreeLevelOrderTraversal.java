package algorithms.medium.tree;

import dataStrucutres.TreeNode;
import lombok.AllArgsConstructor;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/binary-tree-level-order-traversal">...</a>
 * This solution beats 57.31% other Java submissions' memory complexity
 * This solution beats 15.46% other Java submissions' runtime
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new LinkedList<>();

        List<List<Integer>> list = new LinkedList<>();
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(1, root));

        while (!stack.isEmpty()) {
            Pair pair = stack.pop();

            if (list.size() < pair.level) {
                List<Integer> newLevel = new LinkedList<>();
                newLevel.add(pair.node.val);
                list.add(newLevel);
            } else {
                list.get(pair.level - 1).add(pair.node.val);
            }

            if (pair.node.right != null) stack.push(new Pair(pair.level + 1, pair.node.right));
            if (pair.node.left != null) stack.push(new Pair(pair.level + 1, pair.node.left));
        }
        return list;
    }

    @AllArgsConstructor
    private static class Pair {

        public int level;

        public TreeNode node;
    }
}
