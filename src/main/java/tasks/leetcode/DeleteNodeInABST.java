package tasks.leetcode;

public class DeleteNodeInABST {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int v) {
            this.val = v;
        }
    }
    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            int min = minValue(root.right);
            root.right = deleteNode(root.right, min);
            root.val = min;
        }
        return root;
    }

    private static int minValue(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.val;
    }

    public static void main(String[] args) {
        TreeNode t5 = new TreeNode(5);
        TreeNode t3 = new TreeNode(3);
        TreeNode t6 = new TreeNode(6);
        TreeNode t2 = new TreeNode(2);
        TreeNode t4 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);

        t5.left = t3;
        t5.right = t6;
        t3.left = t2;
        t3.right = t4;
        t6.right = t7;

        deleteNode(t5, 3);
    }
}
