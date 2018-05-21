package tasks.leetcode;

public class CountCompleteTreeNodes {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public static int countNodes(TreeNode root) {
        if (root == null) return 0;

        int left = leftHeight(root.left);
        int right = leftHeight(root.right);

        if (left == right)
            return (1 << left) + countNodes(root.right);
        else
            return (1 << right) + countNodes(root.left);
    }

    private static int leftHeight(TreeNode node) {
        return node == null ? 0 : leftHeight(node.left) + 1;
    }
}
