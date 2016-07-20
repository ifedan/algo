package datastructures;

public class BinarySearchTree {

    private class Node {
        Node left;
        Node right;
        int val;

        Node(int val) {
            this.val = val;
        }
    }

    private Node insert(Node node, int val) {
        if (node == null) return new Node(val);
        if (node.val > val) {
            node.left = insert(node.left, val);
        } else if (node.val < val) {
            node.right = insert(node.right, val);
        }
        return node;
    }

    private Node delete(Node node, int val) {
        if (node == null) return node;
        if (node.val > val) {
            node.left = delete(node.left, val);
        } else if (node.val < val) {
            node.right = delete(node.right, val);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            else {
                int minValue = minValue(node.right);
                node.val = minValue;
                node.right = delete(node.right, minValue);
            }
        }
        return node;
    }

    private int minValue(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.val;
    }

}
