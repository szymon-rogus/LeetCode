package algorithms.easy.tree;

import dataStructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/average-of-levels-in-binary-tree">...</a>
 * This solution beats 26.15% other Java submissions' runtime
 * This solution beats 88.75% other Java submissions' memory complexity
 */
public class AverageOfLevelsInBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        List<TreeNode> tempList = new ArrayList<>();
        List<Double> solution = new ArrayList<>();
        list.add(root);

        while (!list.isEmpty()) {
            double counter = 0;
            double sum = 0;
            while (!list.isEmpty()) {
                TreeNode node = list.removeFirst();
                sum += node.val;
                counter++;
                if (node.left != null) tempList.add(node.left);
                if (node.right != null) tempList.add(node.right);
            }
            double avg = sum / counter;
            solution.add(avg);
            /// our tempList hold next level, so we move it to original list to process it in the next step
            /// tempList needs to be cleared to hold following level in the next step
            list.addAll(tempList);
            tempList.clear();
        }

        return solution;
    }
}
