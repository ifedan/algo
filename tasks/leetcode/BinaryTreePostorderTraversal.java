package tasks.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public List<Integer> preorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode last = null;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode peek = stack.peek();

                if (peek.right != null && last != peek.right) {
                    root = peek.right;
                } else {
                    result.add(peek.val);
                    last = stack.pop();
                }
            }
        }
        return result;
    }
}
