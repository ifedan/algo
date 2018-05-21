package tasks.leetcode;

public class PathSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return helper(root, sum);
    }

    private static boolean helper(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return sum == root.val;
        return helper(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }
}
