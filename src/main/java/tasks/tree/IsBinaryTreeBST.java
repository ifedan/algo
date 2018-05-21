package tasks.tree;

public class IsBinaryTreeBST {

    static class Node {
        Node left;
        Node right;
        int val;
    }

    public static boolean solve(Node node, int lo, int hi) {
        if (node == null) return true;

        if (node.val > hi || node.val < lo) {
            return false;
        }

        return solve(node.left, lo, node.val-1) && solve(node.right, node.val+1, hi);

    }
}
