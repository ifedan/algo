package tasks.leetcode;

import java.util.Stack;

public class BinarySearchTreeIterator {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public class BSTIterator {

        private Stack<TreeNode> stack = new Stack<TreeNode>();

        public BSTIterator(TreeNode root) {
            dfs(root, stack);
        }

        private void dfs(TreeNode root, Stack<TreeNode> stack) {
            if (root == null) return;
            stack.push(root);
            dfs(root.left, stack);
        }

        //@return whether we have a next smallest number
	    public boolean hasNext() {
	        return !stack.isEmpty();
	    }

	    //@return the next smallest number
	    public int next() {
	        TreeNode node = stack.pop();
	        dfs(node.right, stack);
	        return node.val;
	    }
	}
}
