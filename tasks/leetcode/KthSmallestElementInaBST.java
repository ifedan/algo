package tasks.leetcode;

public class KthSmallestElementInaBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int kthSmallest(TreeNode root, int k) {
        int left = size(root.left);
        if (left >= k) {
            return kthSmallest(root.left, k);
        } else if (left < k-1) {
            return kthSmallest(root.right, k-1-left);
        } else {
            return root.val;
        }
    }

    public static int size(TreeNode root) {
        return root == null ? 0 : size(root.left) + size(root.right) + 1;
    }

}
