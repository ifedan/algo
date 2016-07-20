package tasks.tree;

public class BTSize {

    static class Node {
        Node left;
        Node right;
    }

    public static int size(Node node) {
        return node == null ? 0 : size(node.left) + size(node.right) + 1;
    }

}
