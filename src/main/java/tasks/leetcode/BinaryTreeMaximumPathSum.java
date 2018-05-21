package tasks.leetcode;

public class BinaryTreeMaximumPathSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        int r = maxPath(root);
        return Math.max(max, r);

    }

    public int max = Integer.MIN_VALUE;

    public int maxPath(TreeNode root) {
        if (root.left == null && root.right == null) return root.val;

        int left;
        int path = root.val;
        if (root.left != null) {
            left = maxPath(root.left);
            path += left;
        } else {
            left = Integer.MIN_VALUE;
        }

        int right;
        if (root.right != null) {
            right = maxPath(root.right);
            path += right;
        } else {
            right = Integer.MIN_VALUE;
        }

        int maxHere = Math.max(root.val, Math.max(left, right) + root.val);

        max = Math.max(max, maxHere);
        max = Math.max(max, left);
        max = Math.max(max, right);
        max = Math.max(max, path);

        return maxHere;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
        root.left = new TreeNode(1);
        //root.right = new TreeNode(3);

        BinaryTreeMaximumPathSum t = new BinaryTreeMaximumPathSum();
        int v= t.maxPathSum(root);
        System.out.println(v);
    }

}
