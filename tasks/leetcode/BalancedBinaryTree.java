package tasks.leetcode;

public class BalancedBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static class Result {
        boolean balanced;
        int height;
        Result(boolean b, int h) {
            this.balanced = b;
            this.height = h;
        }
    }
    public static Result isBalanced(TreeNode root) {
        if (root == null) return new Result(true, 0);
        Result left = isBalanced(root.left);
        Result right = isBalanced(root.right);
        if (!left.balanced || !right.balanced) return right;
        if (Math.abs(left.height - right.height) <= 1) {
            return new Result(true, Math.max(left.height, right.height) + 1);
        } else {
            return new Result(false, 0);
        }
    }

}
