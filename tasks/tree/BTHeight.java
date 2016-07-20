package tasks.tree;

public class BTHeight {

    static class Node {
        Node left;
        Node right;
    }

    public static int height(Node node) {
        return node == null ? 0 : Math.max(height(node.left), height(node.right)) + 1;
    }

}
