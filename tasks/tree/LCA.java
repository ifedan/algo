package tasks.tree;

public class LCA {

    static class Node {
        Node left;
        Node right;
        int val;
    }

    public static Node LCA(Node node, int a, int b) {
        if (node == null) return null;
        if (node.val > a && node.val > b) {
            return LCA(node.left, a, b);
        } else if (node.val < a && node.val < b) {
            return LCA(node.right, a, b);
        }
        return node;
    }

}
