package tasks.leetcode;

public class SymmetricTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    public static boolean isSymmetric(TreeNode a, TreeNode b) {
        if ((a == null && b != null) || (a != null && b == null)) return false;
        if (a == null && b == null) return true;
        if (a.val != b.val) return false;
        return isSymmetric(a.left, b.right) && isSymmetric(a.right, b.left);
    }

}
