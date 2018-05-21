package tasks.tree;

public class IsSameBT {

    static class Node {
        Node left;
        Node right;
        int val;
    }

    public static boolean solve(Node a, Node b) {
        if ((a == null || b == null) && a!=b) return false;
        if (a == null && b == null) return true;
        if (a.val != b.val) return false;
        return solve(a.left, b.left) && solve(a.right, b.right);

    }

}
