package tasks.leetcode;

public class ValidateBinarySearchTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public static boolean isValidBST(TreeNode node) {
        return isValidBST(node, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val >= max || node.val <= min) return false;
        return isValidBST(node.left, min, node.val) &&
                isValidBST(node.right, node.val, max);

    }

}
