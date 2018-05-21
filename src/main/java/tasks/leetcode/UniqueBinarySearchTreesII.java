package tasks.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UniqueBinarySearchTreesII {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) return Collections.EMPTY_LIST;
        return generateTrees(1, n);
    }

    public static List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> left = generateTrees(start, i - 1);
            List<TreeNode> right = generateTrees(i + 1, end);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode node =  new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    result.add(node);
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        generateTrees(3);
    }

}
