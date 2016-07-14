package datastructures;

/**
 * User: ifedan
 * Date: 4/23/15
 */
public class RedBlackTree {

    private static class Node {
        int i;
        Node left;
        Node right;
        boolean red;
        int size;

        Node(int i) {
            this.i = i;
            this.red = true;
            size = 1;
        }

    }

    private Node root;

    public void put(int i) {
        root = put(root, i);
        root.red = false;
    }

    public Node put(Node node, int i) {
        if (node == null) return new Node(i);

        if (i > node.i) node.right = put(node.right, i);
        else if (i < node.i) node.left = put(node.left, i);
        else node.i = i;

        if (!node.left.red && node.right.red) node = rotateLeft(node);
        if (node.left.red && node.left.left.red) node = rotateRight(node);
        if (node.left.red && node.right.red) flipColors(node);

        setSize(node);

        return node;
    }

    private Node rotateLeft(Node node) {
        Node x = node.right;
        node.right = x.left;
        x.left = node;
        x.red = x.left.red;
        x.left.red = true;
        x.size = node.size;
        setSize(node);
        return x;
    }

    private Node rotateRight(Node node) {
        Node x = node.left;
        node.right = x.right;
        x.right = node;
        x.red = x.right.red;
        x.right.red = true;
        x.size = node.size;
        setSize(node);
        return x;
    }

    private void flipColors(Node node) {
        node.red = !node.red;
        node.left.red = !node.left.red;
        node.right.red = !node.right.red;
    }

    private void setSize(Node node) {
        node.size = (node.left != null ? node.left.size : 0) + (node.right != null ? node.right.size : 0) + 1;
    }

    public static void main(String[] args)
    {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(1);
        tree.insert(1);
        tree.insert(2);
        tree.insert(6);
        tree.insert(5);
        tree.insert(2);
        tree.insert(10);
        tree.insert(3);
        tree.insert(11);
        System.out.println("");
    }

}
