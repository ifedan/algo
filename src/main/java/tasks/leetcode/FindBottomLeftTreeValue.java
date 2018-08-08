package tasks.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode left = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    left = node;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return left.val;
    }
}
