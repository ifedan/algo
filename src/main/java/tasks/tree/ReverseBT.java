package tasks.tree;

public class ReverseBT {

    static class Node {
        Node left;
        Node right;
    }

    public static void reverse(Node node) {
        if (node == null) return;
        Node right = node.right;
        node.right = node.left;
        node.left = right;
        reverse(node.left);
        reverse(node.right);
    }

}
