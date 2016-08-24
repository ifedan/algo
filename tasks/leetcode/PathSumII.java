package tasks.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void pathSum(TreeNode root, int sum, List<Integer> output, List<List<Integer>> result) {
        if (root == null) return;
        if (root.left == null && root.right == null && sum == root.val) {
            output.add(root.val);
            result.add(new ArrayList<Integer>(output));
            output.remove(output.size()-1);
            return;
        }
        output.add(root.val);
        pathSum(root.left, sum-root.val, output, result);
        pathSum(root.right, sum-root.val, output, result);
        output.remove(output.size()-1);
    }

}
