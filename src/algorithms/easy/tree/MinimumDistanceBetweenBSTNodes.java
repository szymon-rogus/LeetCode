package algorithms.easy.tree;

import dataStrucutres.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class MinimumDistanceBetweenBSTNodes {

    public int minDiffInBST(TreeNode root) {
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

    private void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;

        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }
}
