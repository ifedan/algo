package tasks.tree;

public class LCAInBT {
    static class Node {
        Node left;
        Node right;
        int val;
    }

    public static Node solve(Node node, int a, int b) {
        if (node == null) return null;
        if (node.val == a || node.val == b) {
            return node;
        }
        Node left = solve(node.left, a, b);
        Node right = solve(node.right, a, b);

        if (left != null && right != null) {
            return node;
        }

        return left != null ? left : right;
    }
}
