package tasks.leetcode;

public class SmallestSubtreeWithAllTheDeepestNodes {

    public static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode t0 = new TreeNode(0);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);

        t3.left = t5;
        t3.right = t1;
        t1.left = t0;
        t1.right = t8;
        t5.left = t6;
        t5.right = t2;
        t2.left = t7;
        t2.right = t4;

        subtreeWithAllDeepest(t3);
    }

    public static TreeNode subtreeWithAllDeepest(TreeNode root) {
        Pair res = bfs(root, 0);
        return res.node;
    }

    public static Pair bfs(TreeNode root, int level) {
        if (root == null) {
            return new Pair(level, null);
        }
        Pair left = bfs(root.left, level+1);
        Pair right = bfs(root.right, level+1);
        if (left.max > right.max) {
            return left;
        } else if (left.max < right.max) {
            return right;
        } else {
            return new Pair(left.max, root);
        }
    }

    static class Pair {
        int max;
        TreeNode node;
        Pair(int m, TreeNode n) {
            max = m;
            node = n;
        }
    }
}
