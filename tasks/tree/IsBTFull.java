package tasks.tree;


public class IsBTFull {

    static class Node {
        Node left;
        Node right;
    }

    public static boolean solve(Node node) {
        if (node.left == null && node.right == null) {
            return true;
        }
        if (node.left == null || node.right == null) {
            return false;
        }
        return solve(node.left) && solve(node.right);
    }
}
