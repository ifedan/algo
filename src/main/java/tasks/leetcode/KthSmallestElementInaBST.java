package tasks.leetcode;

import java.util.Stack;

public class KthSmallestElementInaBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        while (!stack.isEmpty() && root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                count++;
                if (count == k) {
                    return root.val;
                }
                root = root.right;
            }
        }
        return -1;
    }

    public int kthSmallest2(TreeNode root, int k) {
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
