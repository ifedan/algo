package tasks.leetcode;

public class BinaryTreePruning {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = pruneTree(root.left);
        TreeNode right = pruneTree(root.right);
        if (left == null && right == null && root.val == 0) return null;
        TreeNode r = new TreeNode(root.val);
        r.left = left;
        r.right = right;
        return r;
    }
}
