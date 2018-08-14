package tasks.leetcode;

public class InorderSuccessorInBST {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    TreeNode node = null;
    boolean find = false;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        bfs(root, p);
        return node;
    }

    public void bfs(TreeNode root, TreeNode p) {
        if (root == null) return;
        bfs(root.left, p);
        if (find && node == null) {
            node = root;
        }
        if (root == p) {
            find = true;
        }
        bfs(root.right, p);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);

        t1.left = t2;
        t1.right = t5;
        t2.left = t3;
        t2.right = t4;

        InorderSuccessorInBST test = new InorderSuccessorInBST();
        test.inorderSuccessor(t1, t2);

    }
}
